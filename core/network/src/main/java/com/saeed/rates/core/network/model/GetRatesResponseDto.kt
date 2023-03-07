package com.saeed.rates.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class GetRatesResponseDto(
    val rates: List<RateDto>
)