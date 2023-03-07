package com.saeed.rates.core.data.di

import com.saeed.rates.core.data.repository.RatesRepository
import com.saeed.rates.core.data.repository.impl.RatesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsTopicRepository(
        RatesRepository: RatesRepositoryImpl,
    ): RatesRepository
}
