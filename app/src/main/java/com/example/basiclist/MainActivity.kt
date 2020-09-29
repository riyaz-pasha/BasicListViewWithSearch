package com.example.basiclist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private val title = ArrayList<String>();
    private val description = ArrayList<String>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonData = getJsonDataFromAsset(this, "sample.json")
        val item = JSONArray(jsonData)
        for (i in 0 until item.length()) {
            val itemDetail = item.getJSONObject(i)
            title.add(itemDetail.getString("title"))
            description.add(itemDetail.getString("description"))
        }
        findViewById<ListView>(R.id.basicList).adapter = MyListAdapter(this, title, description)
    }
}
