package com.example.myapplication.tuan3

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.animateDecay
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class T3ListviewMainActivity : AppCompatActivity() {
    var adapter:T3Adapter? = null
    var ls = ArrayList<T3Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_t3_listview_main)
        var lv = findViewById<ListView>(R.id.t3listview)
        // them du lieu vao listview
        ls.add(T3Contact("Ha Canh Tung", "20", R.drawable.android))
        ls.add(T3Contact("Vu thi minh hue", "20", R.drawable.apple))
        ls.add(T3Contact("Nguyen Van A", "20", R.drawable.blogger))
        ls.add(T3Contact("Trinh Van B", "20", R.drawable.facebook))
        ls.add(T3Contact("Phung Quoc Viet", "20", R.drawable.hp))
        ls.add(T3Contact("Nguyen Thi Hoa", "20", R.drawable.twitter))
        ls.add(T3Contact("Tran Van A", "20", R.drawable.ie))
        ls.add(T3Contact("Nguyen Gia Huy", "20", R.drawable.firefox))
        ls.add(T3Contact("Nguyen Tuan Linh", "20", R.drawable.microsoft))
        ls.add(T3Contact("Phung Thi B", "20", R.drawable.chrome))

        // tao adapter
        adapter = T3Adapter(ls, this)
        // gan du lieu len adapter
        lv!!.adapter = adapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            var systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}