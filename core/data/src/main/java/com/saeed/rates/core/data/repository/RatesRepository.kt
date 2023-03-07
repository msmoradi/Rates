package com.saeed.rates.core.data.repository

import com.saeed.rates.core.model.RateModel

interface RatesRepository {

    suspend fun getRateList(): List<RateModel>
}
