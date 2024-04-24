package com.example.myapplication.tuan4

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.toolbox.Volley
import com.example.myapplication.R

class Tuan4VolleyMainActivity : AppCompatActivity() {
    var context : Context = this
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tuan4_volley_main)
        var btn1 = findViewById<Button>(R.id.tuan4btn1)
        var tv1 = findViewById<TextView>(R.id.tuan4tv1)
        val fn1 = Tuan4Volley()
        btn1.setOnClickListener{
            fn1.getJsonArrayOfObject(context, tv1)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}