package com.saeed.rates.core.testing.repository

import com.saeed.rates.core.data.repository.RatesRepository
import com.saeed.rates.core.model.RateModel
import com.saeed.rates.core.testing.data.ratesTestData

class TestRatesRepository : RatesRepository {

    override suspend fun getRateList(): List<RateModel> {
        return ratesTestData
    }
}