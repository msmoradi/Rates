package com.saeed.rates.feature.home

import com.saeed.rates.core.model.RateModel

data class HomeUiModel(
    val rateList: List<RateModel>,
    val lastTimeUpdate: String
)