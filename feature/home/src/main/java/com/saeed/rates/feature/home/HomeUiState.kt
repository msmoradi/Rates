package com.saeed.rates.feature.home

sealed interface HomeUiState {
    data class Success(val homeUiModel: HomeUiModel) : HomeUiState
    data class Error(val exception: Throwable) : HomeUiState
    object Loading : HomeUiState
}