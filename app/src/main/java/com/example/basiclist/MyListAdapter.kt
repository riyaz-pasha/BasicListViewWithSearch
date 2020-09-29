package com.example.basiclist

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyListAdapter(
    private val context: Activity,
    private val title: ArrayList<String>,
    private val description: ArrayList<String>
) : ArrayAdapter<String>(context, R.layout.custom_list, title) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)

        val titleText = rowView.findViewById<TextView>(R.id.title)
        val descriptionText = rowView.findViewById<TextView>(R.id.description)

        titleText.text = title[position]
        descriptionText.text = description[position]

        return rowView
    }
}