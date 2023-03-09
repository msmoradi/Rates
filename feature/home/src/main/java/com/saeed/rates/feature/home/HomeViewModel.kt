package com.saeed.rates.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saeed.rates.core.domain.GetRateListUseCase
import com.saeed.rates.core.result.Result
import com.saeed.rates.core.result.asResult
import com.saeed.rates.core.data.repository.TimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

const val DEFAULT_ERROR_MESSAGE = "Unknown error"
private const val POLL_RATES_PERIOD_MILLIS = 120_000L
val DEFAULT_EXCEPTION = Throwable(DEFAULT_ERROR_MESSAGE)

@HiltViewModel
class HomeViewModel @Inject constructor(
    timeRepository: TimeRepository,
    getRateListUseCase: GetRateListUseCase,
) : ViewModel() {

    private var needPolling = true

    val homeUiState: StateFlow<HomeUiState> = channelFlow {
        while (!isClosedForSend) {
            if (needPolling.not()) {
                close()
                return@channelFlow
            }
            send(getRateListUseCase())
            delay(POLL_RATES_PERIOD_MILLIS)
        }
    }
        .asResult()
        .map { rateListResult ->
            when (rateListResult) {
                is Result.Error -> HomeUiState.Error(
                    rateListResult.exception ?: DEFAULT_EXCEPTION
                )
                Result.Loading -> HomeUiState.Loading
                is Result.Success -> HomeUiState.Success(
                    HomeUiModel(
                        rateListResult.data,
                        lastTimeUpdate = timeRepository.getCurrentTime()
                    )
                )
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_00),
            initialValue = HomeUiState.Loading,
        )

    override fun onCleared() {
        super.onCleared()
        needPolling = false
    }
}