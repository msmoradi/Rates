package com.saeed.rates.feature.home

import com.saeed.rates.core.model.RateModel

sealed interface HomeUiState {
    data class Success(val rates: List<RateModel>) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}