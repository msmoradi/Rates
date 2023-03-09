package com.saeed.rates.feature.home

import com.saeed.rates.core.domain.GetRateListUseCase
import com.saeed.rates.core.testing.data.ratesTestData
import com.saeed.rates.core.testing.data.timeTestData
import com.saeed.rates.core.testing.repository.TestRatesRepository
import com.saeed.rates.core.testing.repository.TestTimeRepository
import com.saeed.rates.core.testing.util.MainDispatcherRule
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val ratesRepository = TestRatesRepository()
    private val timeRepository = TestTimeRepository()
    private val getRateListUseCase = GetRateListUseCase(ratesRepository)
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel(
            timeRepository,
            getRateListUseCase
        )
    }

    @Test
    fun homeUiState_whenInitialized_thenShowLoading() = runTest {
        assertEquals(HomeUiState.Loading, viewModel.homeUiState.value)
    }

    @Test
    fun homeUiState_whenGetRateListCollected_thenSuccessState() = runTest {
        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.homeUiState.collect() }

        assertIs<HomeUiState.Success>(viewModel.homeUiState.value)

        collectJob.cancel()
    }

    @Test
    fun homeUiState_whenGetRateListSuccess_thenShowHomeUiModel() = runTest {
        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.homeUiState.collect() }

        val homeUiModel = HomeUiModel(
            ratesTestData,
            timeTestData
        )

        assertEquals(
            HomeUiState.Success(homeUiModel),
            viewModel.homeUiState.value,
        )

        collectJob.cancel()
    }
}