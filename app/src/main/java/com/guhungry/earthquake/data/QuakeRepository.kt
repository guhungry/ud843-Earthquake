package com.guhungry.earthquake.data

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.ANRequest

class QuakeRepository {
    companion object {
        val URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=5&limit=10"

        fun getQuakes(url: String): ANRequest<out ANRequest<*>>? {
            return AndroidNetworking.get(url).build()
        }
    }
}