package com.guhungry.earthquake

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.guhungry.earthquake.adapters.QuakeAdapter
import com.guhungry.earthquake.models.QuakeModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayOf(
                QuakeModel(magnitude = 1.5, place = "Bangna", time = 100000),
                QuakeModel(magnitude = 2.5, place = "Bang Rak Noi", time = 200000),
                QuakeModel(magnitude = 3.5, place = "LA", time = 300000)
        )
        list_quake.adapter = QuakeAdapter(this, R.layout.list_item_quake, list)
    }
}
