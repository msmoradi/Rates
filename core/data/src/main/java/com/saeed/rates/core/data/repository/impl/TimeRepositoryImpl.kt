package com.saeed.rates.core.data.repository.impl

import com.saeed.rates.core.data.repository.TimeRepository
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class TimeRepositoryImpl @Inject constructor() : TimeRepository {

    private fun Date.toDateString(
        format: String = "dd/MM/yyyy - HH:mm",
        locale: Locale = Locale.getDefault()
    ): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    private fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

    override fun getCurrentTime(): String {
        return getCurrentDateTime().toDateString()
    }
}