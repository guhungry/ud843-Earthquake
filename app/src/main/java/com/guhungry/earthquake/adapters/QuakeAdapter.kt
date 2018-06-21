package com.guhungry.earthquake.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.guhungry.earthquake.models.QuakeModel
import kotlinx.android.synthetic.main.list_item_quake.view.*

class QuakeAdapter(context: Context, private val viewId: Int, list: Array<QuakeModel>) : ArrayAdapter<QuakeModel>(context, viewId, list) {
    val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater.inflate(viewId, parent, false)
        val data = getItem(position)

        view.setTag(data)
        view.magnitude.text = data.magnitude.toString()
        view.time.text = data.time.toString()
        return view
    }
}