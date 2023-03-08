package com.saeed.rates.feature.home.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saeed.rates.core.designsystem.DevicePreviews
import com.saeed.rates.core.designsystem.theme.RatesTheme
import com.saeed.rates.core.model.previewRates
import com.saeed.rates.feature.home.HomeUiModel

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    homeUiModel: HomeUiModel,
) {
    Column(modifier = modifier.padding(vertical = 44.dp)) {
        LazyColumn(
            modifier = modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 24.dp)
        ) {
            item {
                Text(
                    text = "Rates",
                    modifier = Modifier,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
            items(
                key = { it.title },
                items = homeUiModel.rateList
            ) { rateModel ->
                RateRow(rateModel = rateModel)
            }
        }
        Text(
            text = "Last updated: ${homeUiModel.lastTimeUpdate}",
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.secondary,
        )
    }
}

@DevicePreviews
@Composable
fun HomeContentPreview() {
    RatesTheme {
        HomeContent(
            homeUiModel = HomeUiModel(previewRates, "30/03/2023 - 16:00")
        )
    }
}