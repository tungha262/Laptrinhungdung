package com.example.myapplication.tuan61

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.privacysandbox.tools.core.model.Method
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.R
import com.example.myapplication.tuan6.Product
import com.example.myapplication.tuan6.ProductAdapter
import com.android.volley.Request
import com.android.volley.Response


class Tuan61MainActivity : AppCompatActivity() {

    private lateinit var lst: ArrayList<Product>
    private lateinit var adt: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_t6_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        lst = ArrayList()
        val queue = Volley.newRequestQueue(this)
        val url = "https://hungnttg.github.io/shopgiay.json"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val productArray = response.getJSONArray("products")
                for (i in 0 until productArray.length()){
                    try{
                        val productObject = productArray.getJSONObject(i)
                        val searchImage = productObject.getString("search_image")
                        val styleId = productObject.getString("styleid")
                        val brand = productObject.getString("brands_filter_facet")
                        val price = productObject.getInt("price")
                        val additionalInfo = productObject.getString("product_additional_info")
                        lst.add(Product(styleId, brand, price, additionalInfo, searchImage))
                    }
                    catch (e : Exception){
                        e.printStackTrace()
                    }
                }

                adt = ProductAdapter(lst, this)
                val lv6 = findViewById<ListView>(R.id.t61listview)
                lv6.adapter = adt
            },
            { error ->
                Log.e("Error", "Error: $error")
            }

        )
        queue.add(jsonObjectRequest)
    }
}