package com.example.myapplication.tuan4

import android.content.Context
import android.widget.TextView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class Tuan4Volley {
    var strJson = ""
    // ham doc dl tu API
    fun getJsonArrayOfObject(context: Context, textview : TextView){
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
                      strJson += "Id: $id\n"
                      strJson += "Name: $name\n"
                      strJson += "Email: $email\n"
                  }catch(e : Exception){
                      e.printStackTrace()
                  }
              }
            textview.text = strJson
        }, {
            error -> textview.text = error.message
        })
        //4. Thực thi request
        queue.add(request)
    }
}