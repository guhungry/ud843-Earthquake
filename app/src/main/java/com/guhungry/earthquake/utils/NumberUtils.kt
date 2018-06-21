package com.guhungry.earthquake.utils

import java.text.DecimalFormat

class NumberUtils {
    companion object {
        fun format(number: Double, format: String) = DecimalFormat(format).format(number)
    }
}