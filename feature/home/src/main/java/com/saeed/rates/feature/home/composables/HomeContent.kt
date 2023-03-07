package com.saeed.rates.feature.home.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saeed.rates.core.designsystem.DevicePreviews
import com.saeed.rates.core.designsystem.theme.RatesTheme
import com.saeed.rates.core.model.RateModel
import com.saeed.rates.core.model.previewRates

@Composable
fun HomeContent(
    rates: List<RateModel>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 24.dp)
        ) {

            item {
                Text(
                    text = "Rates",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }

            items(
                key = { it.title },
                items = rates
            ) { rateModel ->
                RateRow(rateModel = rateModel)
            }
        }
    }
}

@DevicePreviews
@Composable
fun HomeContentPreview() {
    RatesTheme {
        HomeContent(
            rates = previewRates
        )
    }
}