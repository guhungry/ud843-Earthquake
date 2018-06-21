package com.guhungry.earthquake

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.guhungry.earthquake.adapters.QuakeAdapter
import com.guhungry.earthquake.data.QuakeRepository
import com.guhungry.earthquake.models.QuakeModel
import com.guhungry.earthquake.utils.QueryUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private var adapter : QuakeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupQuakeList()

        QuakeRepository.getQuakes()?.getAsJSONObject(object : JSONObjectRequestListener {
            override fun onResponse(response: JSONObject) {
                println(response)
                updateQuakes(QueryUtils.extractQuakes(response))
            }

            override fun onError(error: ANError) {
                println(error)
            }
        })
    }

    private fun setupQuakeList() {
        adapter = QuakeAdapter(this, arrayListOf())
        list_quake.adapter = adapter
    }

    fun updateQuakes(quakes: ArrayList<QuakeModel>) {
        adapter?.clear()
        adapter?.addAll(quakes.toMutableList())
        adapter?.notifyDataSetChanged()
    }
}
