package com.guhungry.earthquake.utils

import com.guhungry.earthquake.models.QuakeModel
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class QueryUtils {
    companion object {
        fun extractQuakes(json: String): Array<QuakeModel> {
            val result = mutableListOf<QuakeModel>()

            try {
                val quakes = JSONObject(json).optJSONArray("features")
                for (i in 0 until quakes.length()) {
                    println(quakes.optJSONObject(i))
                    result.add(extractQuake(json = quakes.optJSONObject(i) ?: JSONObject()))
                }

            } catch (e: JSONException) {
                println(e)
            }

            return result.toTypedArray()
        }

        fun extractQuake(json: JSONObject): QuakeModel {
            val props = json.optJSONObject("properties") ?: JSONObject()
            return QuakeModel(
                    magnitude = props.optDouble("magnitude", 0.0),
                    place = props.optString("place", ""),
                    time = Date(props.optLong("time", 0))
            )
        }
    }
}