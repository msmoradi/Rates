package com.saeed.rates.feature.home

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.saeed.rates.core.designsystem.DevicePreviews
import com.saeed.rates.core.designsystem.theme.RatesTheme
import com.saeed.rates.core.model.previewRates
import com.saeed.rates.feature.home.composables.HomeContent

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        homeUiState = HomeUiState.Success,
        modifier = modifier
    )
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
@Composable
internal fun HomeScreen(
    homeUiState: HomeUiState,
    modifier: Modifier = Modifier
) {

    when (homeUiState) {
        HomeUiState.Error -> {}
        HomeUiState.Loading -> {}
        is HomeUiState.Success -> {
            HomeContent(
                rates = previewRates,
                modifier = modifier
            )
        }
    }
}

@DevicePreviews
@Composable
fun HomeScreenPreview() {
    RatesTheme {
        HomeScreen(
            homeUiState = HomeUiState.Success
        )
    }
}