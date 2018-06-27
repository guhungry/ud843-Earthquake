package com.guhungry.earthquake.data

import android.net.Uri
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.ANRequest
import com.guhungry.earthquake.models.QuakeSettingModel

class QuakeRepository {
    companion object {
        val URL = Uri.parse("https://earthquake.usgs.gov/fdsnws/event/1/query")

        fun getQuakes(url: String): ANRequest<out ANRequest<*>>? {
            return AndroidNetworking.get(url).build()
        }

        fun url(setting: QuakeSettingModel): String {
            val builder = URL.buildUpon()

            builder.appendQueryParameter("format", "geojson")
            builder.appendQueryParameter("orderby", setting.orderBy)
            builder.appendQueryParameter("minmag", setting.minMagnitude)
            builder.appendQueryParameter("limit", setting.limit)
            return builder.toString()
        }
    }
}