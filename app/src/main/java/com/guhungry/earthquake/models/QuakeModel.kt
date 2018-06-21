package com.guhungry.earthquake.models

import com.guhungry.earthquake.utils.DateUtils
import com.guhungry.earthquake.utils.NumberUtils
import java.util.*

data class QuakeModel(private val place: String, val magnitude: Double, val time: Date) {
    lateinit var placeOf: String
    lateinit var placeMain: String
    private val PLACE_SEPERATOR = " of "

    init {
        formatPlace()
    }

    private fun formatPlace() {
        if (place.indexOf(PLACE_SEPERATOR) != -1) {
            val values = place.split(PLACE_SEPERATOR)
            placeOf = (values[0] + PLACE_SEPERATOR).toUpperCase()
            placeMain = values[1]
        } else {
            placeOf = "Near the"
            placeMain = place
        }
    }

    fun displayMagnitide() = NumberUtils.format(magnitude, "0.0")
    fun displayDate() = DateUtils.format(time, DateUtils.FORMAT_DATE_MMMDDYYY)
    fun displayTime() = DateUtils.format(time, DateUtils.FORMAT_DATE_HMA)
}
