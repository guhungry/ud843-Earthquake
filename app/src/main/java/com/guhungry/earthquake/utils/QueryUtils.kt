package com.guhungry.earthquake.utils

import android.content.Context
import android.net.Uri
import android.preference.PreferenceManager
import com.guhungry.earthquake.R
import com.guhungry.earthquake.models.QuakeModel
import com.guhungry.earthquake.models.QuakeSettingModel
import org.json.JSONObject
import java.util.*

class QueryUtils {
    companion object {
        private val URL = Uri.parse("https://earthquake.usgs.gov/fdsnws/event/1/query")

        // /////////////
        // Url Functions
        // /////////////
        fun url(setting: QuakeSettingModel): String {
            val builder = URL.buildUpon()

            builder.appendQueryParameter("format", "geojson")
            builder.appendQueryParameter("orderby", setting.orderBy)
            builder.appendQueryParameter("minmag", setting.minMagnitude)
            builder.appendQueryParameter("limit", setting.limit)
            return builder.toString()
        }

        fun settingsFromPreferences(context: Context): QuakeSettingModel {
            val preferences = Preferences(context)

            return QuakeSettingModel(
                    minMagnitude = preferences.getString(R.string.settings_min_magnitude_key, R.string.settings_min_magnitude_label),
                    limit = "10",
                    orderBy = "time")
        }

        // /////////////////////
        // Data Mapper Functions
        // /////////////////////
        fun extractQuakes(json: JSONObject): ArrayList<QuakeModel> {
            val result = arrayListOf<QuakeModel>()
            val quakes = json.optJSONArray("features")

            for (i in 0 until quakes.length()) {
                result.add(extractQuake(json = quakes.optJSONObject(i) ?: JSONObject()))
            }
            return result
        }

        fun extractQuake(json: JSONObject): QuakeModel {
            val props = json.optJSONObject("properties") ?: JSONObject()
            return QuakeModel(
                    place = props.optString("place", ""),
                    magnitude = props.optDouble("mag", 0.0),
                    time = Date(props.optLong("time", 0)),
                    url = props.optString("url", "")
            )
        }
    }
}