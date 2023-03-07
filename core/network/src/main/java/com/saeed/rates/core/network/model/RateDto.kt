package com.saeed.rates.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class RateDto(
    val symbol: String,
    val price: Double
)
