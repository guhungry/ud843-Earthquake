package com.guhungry.earthquake.models

import com.guhungry.earthquake.utils.DateUtils
import java.util.*

data class QuakeModel(val place: String, val magnitude: Double, val time: Date) {
    fun displayDate() = DateUtils.formatDate(time, DateUtils.FORMAT_DATE_MMMDDYYY)
    fun displayTime() = DateUtils.formatDate(time, DateUtils.FORMAT_DATE_HMA)
}
