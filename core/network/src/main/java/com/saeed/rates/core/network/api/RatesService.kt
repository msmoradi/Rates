package com.saeed.rates.core.network.api

import com.saeed.rates.core.network.model.GetRatesResponseDto
import retrofit2.http.GET

interface RatesService {

    @GET("code-challenge/index.php")
    suspend fun getRateList(): GetRatesResponseDto
}