package com.saeed.rates.core.network.di

import com.saeed.rates.core.network.RatesRemoteDataSource
import com.saeed.rates.core.network.datasource.RatesRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindsTopicRepository(
        ratesRemoteDataSource: RatesRemoteDataSourceImpl,
    ): RatesRemoteDataSource
}