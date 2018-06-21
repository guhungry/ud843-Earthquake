package com.guhungry.earthquake.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {
        const val FORMAT_DATE_MMMDDYYY = "MMM d, yyyy"
        const val FORMAT_DATE_HMA = "h:m a"

        fun formatDate(date: Date, format: String): String {
            val formatter = SimpleDateFormat(format, Locale.US)
            return formatter.format(date)
        }
    }
}