package com.saeed.rates.core.model

data class RateModel(
    val title: String,
    val amount: Double,
    val amountState: AmountStatus,
    val imageUrl: String
)

enum class AmountStatus {
    POSITIVE,
    NEGATIVE;

    companion object {

        fun map(int: Int): AmountStatus {
            return when (int) {
                0 -> POSITIVE
                1 -> NEGATIVE
                else -> POSITIVE
            }
        }
    }
}

val previewRates = listOf(
    RateModel(
        title = "GBP/JPY",
        amount = 0.7815,
        amountState = AmountStatus.NEGATIVE,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1280px-Apple_logo_black.svg.png"
    ),
    RateModel(
        title = "AUD/CAD",
        amount = 1.3910,
        amountState = AmountStatus.POSITIVE,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1280px-Apple_logo_black.svg.png"
    ),
    RateModel(
        title = "JPY/AED",
        amount = 0.8682,
        amountState = AmountStatus.POSITIVE,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1280px-Apple_logo_black.svg.png"
    ),
    RateModel(
        title = "EUR/USD",
        amount = 0.1634,
        amountState = AmountStatus.POSITIVE,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1280px-Apple_logo_black.svg.png"
    ),
    RateModel(
        title = "JPY/SEK",
        amount = 0.7930,
        amountState = AmountStatus.POSITIVE,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1280px-Apple_logo_black.svg.png"
    ),
    RateModel(
        title = "USD/GBP",
        amount = 0.5171,
        amountState = AmountStatus.NEGATIVE,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1280px-Apple_logo_black.svg.png"
    ),
)