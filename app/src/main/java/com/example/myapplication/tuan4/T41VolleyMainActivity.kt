package com.example.myapplication.tuan4

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.toolbox.Volley
import com.example.myapplication.R

class T41VolleyMainActivity : AppCompatActivity() {
    var context : Context = this

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_t41_volley_main)
        var lv = findViewById<ListView>(R.id.t4lv1)
        var btn = findViewById<Button>(R.id.t41btn)
        val fn1 = Tuan41Volley()
        btn.setOnClickListener{
            fn1.getJsonArrayOfObject(context, lv)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}