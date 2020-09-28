package com.example.basiclist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val users = arrayOf(
            "Name 1",
            "Name 2",
            "Name 3",
            "Name 4",
            "Name 5",
            "Name 6",
            "Name 7",
            "Name 8",
            "Name 9",
            "Name 10",
            "Name 11",
            "Name 12",
            "Name 13",
            "Name 14",
            "Name 15",
            "Name 16",
            "Name 17",
            "Name 18",
            "Name 19",
            "Name 20"
        )

        findViewById<ListView>(R.id.basicList).adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
    }
}
