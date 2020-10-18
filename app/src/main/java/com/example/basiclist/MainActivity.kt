package com.example.basiclist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private val gameList = ArrayList<Game>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpData()
        println("****len*****" + gameList.size)
        findViewById<RecyclerView>(R.id.basicList).adapter = GameListAdapter(gameList)
    }

    private fun setUpData() {
        val jsonData = getJsonDataFromAsset(this, "sample.json")
        val item = JSONArray(jsonData)
        for (i in 0 until item.length()) {
            val itemDetail = item.getJSONObject(i)
            val title = itemDetail.getString("title")
            val description = itemDetail.getString("description")
            gameList.add(Game(title, description))
        }
    }
}
