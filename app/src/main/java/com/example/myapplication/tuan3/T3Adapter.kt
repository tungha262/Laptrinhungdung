package com.example.myapplication.tuan3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import java.security.AccessControlContext

class T3Adapter(val ls:ArrayList<T3Contact>, val context: Context) : BaseAdapter() {
    // tổng số item
    override fun getCount(): Int {
        return ls.size
    }
    // trả về 1 item
    override fun getItem(position: Int): Any {
        return ls[position]
    }
    // lấy id của 1 item
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    // trả về view : tạo view và gán dl cho view
    override fun getView(position: Int, cvv: View?, parent: ViewGroup?): View {
        // b1: tạo view
        var cvv= cvv
        val vax: ViewAX
        if(cvv == null) // chua co view thi tao view moi
        {
            vax = ViewAX() // tao view moi
            //Anh xa layout itemview
            cvv = LayoutInflater.from(context).inflate(R.layout.t3_item_view, null)
            vax.img_hinh = cvv!!.findViewById(R.id.t3ItemHinh)
            vax.tv_ten = cvv!!.findViewById(R.id.t3ItemTen)
            vax.tv_tuoi = cvv!!.findViewById(R.id.t3ItemTuoi)
            // tạo template để lần sau sử dụng
            cvv.tag = vax
        }
        else{
            vax = cvv.tag as ViewAX
        }
        // gán dữ liệu cho view
        vax.img_hinh!!.setImageResource(ls[position].hinh!!)
        vax.tv_ten!!.text = ls[position].ten
        vax.tv_tuoi!!.text = ls[position].tuoi

        return cvv
    }
    // dinh nghia class view cua Itemview
    internal inner class ViewAX{ // lớp nội đại diện item view tham chiếu vào code
        var img_hinh:ImageView? = null
        var tv_ten:TextView? = null
        var tv_tuoi:TextView? = null
    }

}
