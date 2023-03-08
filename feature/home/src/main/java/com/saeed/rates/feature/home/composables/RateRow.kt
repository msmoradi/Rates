package com.saeed.rates.feature.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saeed.rates.core.designsystem.DevicePreviews
import com.saeed.rates.core.designsystem.R
import com.saeed.rates.core.designsystem.theme.RatesTheme
import com.saeed.rates.core.model.AmountStatus
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
        Image(
            modifier = Modifier.size(44.dp),
            painter = getRateFlagPainter(rateModel.title),
            contentDescription = "Flag Icon"
        )
        Text(
            modifier = Modifier.weight(1f),
            text = rateModel.title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
        )
        AmountSection(
            amount = rateModel.amount,
            color = getAmountColorBasedOnState(rateModel.amountState),
            imageVector = getImageVectorBasedOnState(rateModel.amountState)
        )
    }
}

@Composable
fun getRateFlagPainter(rateName: String): Painter {
    val flagId = when (rateName) {
        "AUDCAD" -> R.drawable.audcad
        "EURUSD" -> R.drawable.eurusd
        "GBPJPY" -> R.drawable.gbpjpy
        "JPYAED" -> R.drawable.jpyaed
        "JPYSEK" -> R.drawable.jpysek
        "USDCAD" -> R.drawable.usdcad
        "USDGBP" -> R.drawable.usdgbp
        else -> R.drawable.audcad
    }
    return painterResource(id = flagId)
}

@Composable
fun getAmountColorBasedOnState(amountState: AmountStatus): Color {
    return when (amountState) {
        AmountStatus.POSITIVE -> MaterialTheme.colorScheme.tertiary
        AmountStatus.NEGATIVE -> MaterialTheme.colorScheme.error
    }
}

@Composable
fun getImageVectorBasedOnState(amountState: AmountStatus): ImageVector {
    return when (amountState) {
        AmountStatus.POSITIVE -> Icons.Default.ArrowUpward
        AmountStatus.NEGATIVE -> Icons.Default.ArrowDownward
    }
}

@DevicePreviews
@Composable
fun PreviewRateRow() {

    RatesTheme {
        RateRow(rateModel = previewRates.first())
    }
}