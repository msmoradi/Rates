package com.saeed.rates.core.network.di

import com.saeed.rates.core.network.api.RatesService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Reusable
    fun provideRatesService(retrofit: Retrofit): RatesService {
        return retrofit.create(RatesService::class.java)
    }
}
