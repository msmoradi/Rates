package com.saeed.rates.feature.home

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.saeed.rates.core.designsystem.DevicePreviews
import com.saeed.rates.core.designsystem.theme.RatesTheme
import com.saeed.rates.core.model.previewRates
import com.saeed.rates.feature.home.composables.ErrorSection
import com.saeed.rates.feature.home.composables.HomeContent
import com.saeed.rates.feature.home.composables.LoadingSection

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val homeUiState by viewModel.homeUiState.collectAsStateWithLifecycle()

    HomeScreen(
        homeUiState = homeUiState,
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(MaterialTheme.colorScheme.background)
    )
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    homeUiState: HomeUiState,
) {
    when (homeUiState) {
        is HomeUiState.Error -> {
            ErrorSection(
                modifier = modifier,
                errorMessage = homeUiState.exception.localizedMessage ?: DEFAULT_ERROR_MESSAGE
            )
        }
        HomeUiState.Loading -> {
            LoadingSection(modifier = modifier)
        }
        is HomeUiState.Success -> {
            HomeContent(
                modifier = modifier,
                homeUiModel = homeUiState.homeUiModel
            )
        }
    }
}

@DevicePreviews
@Composable
fun HomeScreenPreview() {
    RatesTheme {
        HomeScreen(
            homeUiState = HomeUiState.Success(
                HomeUiModel(previewRates, "30/03/2023 - 16:00")
            )
        )
    }
}