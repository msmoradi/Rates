package com.saeed.rates.feature.home.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun Date.toDateString(
    format: String = "dd/MM/yyyy - HH:mm",
    locale: Locale = Locale.getDefault()
): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}