package com.saeed.rates.feature.home

sealed interface HomeUiState {
    object Success : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}