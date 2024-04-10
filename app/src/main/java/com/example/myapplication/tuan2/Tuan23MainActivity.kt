package com.example.myapplication.tuan2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class Tuan23MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tuan23_main)
        var lv1 = findViewById<ListView>(R.id.tuan23lv1)
        // dinh nghia nguon du lieu
        var arr = arrayOf("Item1", "Item2","Item3", "Item4","Item5", "Item6","Item7", "Item8" )
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1,arr)
        lv1.adapter=adapter1
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}