package com.saeed.rates.core.data.repository.impl

import com.saeed.rates.core.data.repository.RatesRepository
import com.saeed.rates.core.model.AmountStatus
import com.saeed.rates.core.model.RateModel
import com.saeed.rates.core.network.RatesRemoteDataSource
import com.saeed.rates.core.network.model.RateDto
import java.text.DecimalFormat
import javax.inject.Inject

class RatesRepositoryImpl @Inject constructor(
    private val datasource: RatesRemoteDataSource,
) : RatesRepository {

    private val lastFetchedItems = mutableListOf<RateModel>()

    override suspend fun getRateList(): List<RateModel> {
        return datasource.getRateList().map {
            RateModel(
                title = it.symbol,
                amount = DecimalFormat("#.####").format(it.price),
                amountState = getAmountState(it),
                imageUrl = it.symbol
            )
        }.also {
            lastFetchedItems.clear()
            lastFetchedItems.addAll(it)
        }
    }

    private fun getAmountState(newRate: RateDto): AmountStatus {
        return lastFetchedItems.firstOrNull {
            it.title == newRate.symbol
        }?.run {
            if (newRate.price >= amount.toDouble()) {
                AmountStatus.POSITIVE
            } else {
                AmountStatus.NEGATIVE
            }
        } ?: AmountStatus.POSITIVE
    }
}