package com.saeed.rates.core.testing.data

import com.saeed.rates.core.model.AmountStatus
import com.saeed.rates.core.model.RateModel

val ratesTestData: List<RateModel> = listOf(
    RateModel(
        title = "GBP/JPY",
        amount = "0.7815",
        amountState = AmountStatus.NEGATIVE,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1280px-Apple_logo_black.svg.png"
    ),
    RateModel(
        title = "AUD/CAD",
        amount = "1.3910",
        amountState = AmountStatus.POSITIVE,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1280px-Apple_logo_black.svg.png"
    ),
    RateModel(
        title = "JPY/AED",
        amount = "0.8682",
        amountState = AmountStatus.POSITIVE,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1280px-Apple_logo_black.svg.png"
    ),
    RateModel(
        title = "EUR/USD",
        amount = "0.1634",
        amountState = AmountStatus.POSITIVE,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1280px-Apple_logo_black.svg.png"
    ),
    RateModel(
        title = "JPY/SEK",
        amount = "0.7930",
        amountState = AmountStatus.POSITIVE,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1280px-Apple_logo_black.svg.png"
    ),
    RateModel(
        title = "USD/GBP",
        amount = "0.5171",
        amountState = AmountStatus.NEGATIVE,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1280px-Apple_logo_black.svg.png"
    ),
)
