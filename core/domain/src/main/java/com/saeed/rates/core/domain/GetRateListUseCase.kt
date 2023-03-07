package com.saeed.rates.core.domain

import com.saeed.rates.core.data.repository.RatesRepository
import com.saeed.rates.core.model.RateModel
import javax.inject.Inject

class GetRateListUseCase @Inject constructor(
    private val ratesRepository: RatesRepository,
) {

    suspend operator fun invoke(): List<RateModel> {
        return ratesRepository.getRateList()
    }
}