package com.saeed.rates.feature.home.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.saeed.rates.core.designsystem.DevicePreviews
import com.saeed.rates.core.designsystem.theme.RatesTheme

@Composable
fun AmountSection(
    modifier: Modifier = Modifier,
    amount: String,
    imageVector: ImageVector,
    color: Color
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = amount,
            style = MaterialTheme.typography.titleMedium,
            color = color,
        )
        Icon(
            imageVector = imageVector,
            contentDescription = "arrow",
            tint = color,
        )
    }
}

@DevicePreviews
@Composable
fun PreviewAmountSection() {
    RatesTheme {
        AmountSection(
            amount = "0.1231",
            color = Green,
            imageVector = Icons.Default.ArrowUpward
        )
    }
}