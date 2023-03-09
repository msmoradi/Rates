package com.saeed.rates.core.testing.repository

import com.saeed.rates.core.data.repository.TimeRepository
import com.saeed.rates.core.testing.data.timeTestData

class TestTimeRepository : TimeRepository {

    override fun getCurrentTime(): String {
        return timeTestData
    }
}