package com.example.myapplication.tuan4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.tuan3.T3Adapter

class T4Adapter(val ls: ArrayList<T4Contact>, val context: Context) :BaseAdapter() {
    override fun getCount(): Int {
        return ls.size
    }

    override fun getItem(position: Int): Any {
        return ls[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, cvv: View?, parent: ViewGroup?): View {
        var cvv = cvv
        var vax: ViewAX
        if(cvv == null){
            vax = ViewAX()
            cvv = LayoutInflater.from(context).inflate(R.layout.t4_item_view, null)
            vax.tv_id = cvv!!.findViewById(R.id.t4tvid)
            vax.tv_ten = cvv!!.findViewById(R.id.t4tvten)
            vax.tv_email = cvv!!.findViewById(R.id.t4tvemail)
            cvv.tag = vax
        }
        else{
            vax = cvv.tag as ViewAX
        }

        vax.tv_ten!!.text = ls[position].ten
        vax.tv_id!!.text = ls[position].id
        vax.tv_email!!.text = ls[position].email

        return cvv

    }
    internal inner class ViewAX{ // lớp nội đại diện item view tham chiếu vào code
        var tv_id: TextView? = null
        var tv_ten: TextView? = null
        var tv_email: TextView? = null
    }

}