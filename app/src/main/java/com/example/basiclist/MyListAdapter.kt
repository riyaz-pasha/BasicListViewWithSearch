package com.example.basiclist

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class MyListAdapter(
    private val context: Activity,
    private val gameList: ArrayList<Game>
) : ArrayAdapter<Game>(context, R.layout.custom_list, gameList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)

        val titleText = rowView.findViewById<TextView>(R.id.title)
        val descriptionText = rowView.findViewById<TextView>(R.id.description)

        titleText.text = gameList[position].title
        descriptionText.text = gameList[position].description

        return rowView
    }

    fun filter(text: String?) {
        val text = text!!.toLowerCase(Locale.getDefault())
    }
}