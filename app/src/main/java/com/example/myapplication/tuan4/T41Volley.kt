package com.example.myapplication.tuan4

import android.content.Context
import android.util.Log
import android.widget.ListView
import android.widget.TextView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class Tuan41Volley {
    var adapter:T4Adapter? = null
    var ls = ArrayList<T4Contact>()
    // ham doc dl tu API
    fun getJsonArrayOfObject(context: Context, listview : ListView){
        //1. Tạo request
        val queue = Volley.newRequestQueue(context)
        //2.  Url
        val url = "https://hungnttg.github.io/array_json_new.json";
        // 3. Goi Request
        // mang cac doi tuong -> goi mang truoc, doi tuong sau
        // JsonArrayRequest (url, neu thanh cong, that bai)
        val request = JsonArrayRequest(url, {response ->
            for(i in 0 until response.length()){
                try{
                    val person = response.getJSONObject(i);
                    val id = person.getString("id")
                    val name = person.getString("name")
                    val email = person.getString("email")
                    // dua tat ca vao chuoi
                    ls.add(T4Contact(id, name, email))
                }catch(e : Exception){
                    e.printStackTrace()
                }
            }
            adapter = T4Adapter(ls,  context)
            listview!!.adapter = adapter
        }, {
                error -> Log.w("Loi", error.message.toString())
        })
        //4. Thực thi request
        queue.add(request)
    }
}