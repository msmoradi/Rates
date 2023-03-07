package com.saeed.rates.core.network.datasource

import com.saeed.rates.core.network.Dispatcher
import com.saeed.rates.core.network.RatesDispatchers
import com.saeed.rates.core.network.RatesRemoteDataSource
import com.saeed.rates.core.network.api.RatesService
import com.saeed.rates.core.network.model.RateDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RatesRemoteDataSourceImpl @Inject constructor(
    @Dispatcher(RatesDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val ratesService: RatesService,
) : RatesRemoteDataSource {

    override suspend fun getRateList(): List<RateDto> {
        return withContext(ioDispatcher) {
            ratesService.getRateList().rates
        }
    }
}