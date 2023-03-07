package com.saeed.rates.feature.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.unit.dp
import com.saeed.rates.core.designsystem.DevicePreviews
import com.saeed.rates.core.designsystem.theme.RatesTheme
import com.saeed.rates.core.model.RateModel
import com.saeed.rates.core.model.previewRates

@Composable
fun RateRow(
    modifier: Modifier = Modifier,
    rateModel: RateModel
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.Flag, contentDescription = "Flag Icon")
        Text(
            modifier = Modifier.weight(1f),
            text = rateModel.title,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Text(
            text = rateModel.amount,
            style = MaterialTheme.typography.labelMedium,
            color = Green,
        )
    }
}

@DevicePreviews
@Composable
fun PreviewRateRow() {

    RatesTheme {
        RateRow(rateModel = previewRates.first())
    }
}