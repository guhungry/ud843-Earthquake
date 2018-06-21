package com.guhungry.earthquake.utils

import com.guhungry.earthquake.models.QuakeModel
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class QueryUtils {
    companion object {
        fun extractQuakes(json: String): ArrayList<QuakeModel> {
            try {
                return extractQuakes(JSONObject(json))
            } catch (e: JSONException) {
                return arrayListOf()
            }
        }

        fun extractQuakes(json: JSONObject): ArrayList<QuakeModel> {
            val result = arrayListOf<QuakeModel>()
            val quakes = json.optJSONArray("features")

            for (i in 0 until quakes.length()) {
                println(quakes.optJSONObject(i))
                result.add(extractQuake(json = quakes.optJSONObject(i) ?: JSONObject()))
            }
            return result
        }

        fun extractQuake(json: JSONObject): QuakeModel {
            val props = json.optJSONObject("properties") ?: JSONObject()
            return QuakeModel(
                    magnitude = props.optDouble("mag", 0.0),
                    place = props.optString("place", ""),
                    time = Date(props.optLong("time", 0))
            )
        }
    }
}