package com.guhungry.earthquake.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.guhungry.earthquake.R
import com.guhungry.earthquake.models.QuakeModel
import kotlinx.android.synthetic.main.quake_list_item.view.*

class QuakeAdapter(context: Context, list: Array<QuakeModel>, private val viewId: Int = R.layout.quake_list_item) : ArrayAdapter<QuakeModel>(context, viewId, list) {
    private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater.inflate(viewId, parent, false)
        val data = getItem(position)

        view.setTag(data)
        view.magnitude.text = data.magnitude.toString()
        view.time.text = data.time.toString()
        return view
    }
}