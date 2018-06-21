package com.guhungry.earthquake

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.guhungry.earthquake.adapters.QuakeAdapter
import com.guhungry.earthquake.models.QuakeModel
import com.guhungry.earthquake.quakelist.QuakeListProtocol
import com.guhungry.earthquake.quakelist.QuakeListRouter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), QuakeListProtocol.View {
    override var presenter: QuakeListProtocol.Presenter? = null
    private var adapter: QuakeAdapter? = null

    // ////////////////////
    // Life Cycle Functions
    // ////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPresenter()
        setupQuakeList()
    }

    private fun setupPresenter() {
        presenter = QuakeListRouter.presenter(this)
    }

    private fun setupQuakeList() {
        adapter = QuakeAdapter(this, arrayListOf())
        list_quake.adapter = adapter
    }

    override fun onStart() {
        super.onStart()

        presenter?.requestQuakes()
    }

    override fun onDestroy() {
        adapter = null
        presenter = null
        super.onDestroy()
    }

    // //////////////
    // View Interface
    // //////////////
    override fun onQuakesSuccess(quakes: ArrayList<QuakeModel>) {
        adapter?.clear()
        adapter?.addAll(quakes.toMutableList())
        adapter?.notifyDataSetChanged()
    }

    override fun onQuakesFailed() {
        Toast.makeText(this, "Can't load quake data", Toast.LENGTH_LONG).show()
    }
}
