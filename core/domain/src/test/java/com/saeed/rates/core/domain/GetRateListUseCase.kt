package com.saeed.rates.core.domain

import com.saeed.rates.core.testing.util.MainDispatcherRule
import com.saeed.rates.core.testing.data.ratesTestData
import com.saeed.rates.core.testing.repository.TestRatesRepository
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class GetRateListUseCaseTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val ratesRepository = TestRatesRepository()

    val useCase = GetRateListUseCase(
        ratesRepository
    )

    @Test
    fun useCase_rateListAreReturned() = runTest {

        val rateList = useCase()

        assertEquals(
            rateList,
            ratesTestData,
        )
    }
}