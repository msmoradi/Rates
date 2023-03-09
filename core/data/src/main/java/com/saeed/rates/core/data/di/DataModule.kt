package com.saeed.rates.core.data.di

import com.saeed.rates.core.data.repository.RatesRepository
import com.saeed.rates.core.data.repository.TimeRepository
import com.saeed.rates.core.data.repository.impl.RatesRepositoryImpl
import com.saeed.rates.core.data.repository.impl.TimeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsRatesRepository(
        ratesRepository: RatesRepositoryImpl,
    ): RatesRepository

    @Binds
    fun bindsTimeRepository(
        timeRepository: TimeRepositoryImpl,
    ): TimeRepository
}
