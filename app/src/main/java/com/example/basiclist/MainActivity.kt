package com.example.basiclist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import com.example.basiclist.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private val gameList = ArrayList<Game>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpData()
        val adapter = GameListAdapter(gameList)
        binding.basicList.adapter = adapter
        binding.searchGame.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
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
