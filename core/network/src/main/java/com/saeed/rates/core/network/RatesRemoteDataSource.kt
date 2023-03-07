package com.saeed.rates.core.network

import com.saeed.rates.core.network.model.RateDto

interface RatesRemoteDataSource {

    suspend fun getRateList(): List<RateDto>
}
