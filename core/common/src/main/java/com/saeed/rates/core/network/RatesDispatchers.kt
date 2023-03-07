package com.saeed.rates.core.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val dispatcher: RatesDispatchers)

enum class RatesDispatchers {
    IO
}