package com.saeed.rates.feature.home

sealed interface HomeUiState {
    data class Success(val homeUiModel: HomeUiModel) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}