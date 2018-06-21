package com.guhungry.earthquake.data

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.ANRequest

class QuakeRepository {
    companion object {
        fun getQuakes(): ANRequest<out ANRequest<*>>? {
            return AndroidNetworking.get("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02&minmagnitude=1").build()
        }
    }
}