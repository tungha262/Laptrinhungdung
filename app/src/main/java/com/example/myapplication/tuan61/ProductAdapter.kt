package com.example.myapplication.tuan6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.squareup.picasso.Picasso

class ProductAdapter(val ls : ArrayList<Product>, val context : Context): BaseAdapter() {
    override fun getCount(): Int {
        return ls.size;
    }

    override fun getItem(position: Int): Any {
        return ls[position];
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var cvv = convertView
        val vax: ViewAx
        if (cvv == null){
            vax = ViewAx()
            cvv = LayoutInflater.from(context).inflate(R.layout.item_view_t6,  null)
            vax.imageView = cvv.findViewById(R.id.item_product_imageView);
            vax.styleID = cvv.findViewById(R.id.item_styleIDtv);
            vax.brand = cvv.findViewById(R.id.item_brandtv);
            vax.price = cvv.findViewById(R.id.item_pricetv);
            vax.info = cvv.findViewById(R.id.item_additionalInfotv);

            cvv.tag = vax
        }
        else{
            vax = cvv.tag as ViewAx
        }

        val product : Product = ls[position];
        if (product!=null){
            Picasso.get().load(product.image).into(vax.imageView)
            vax.styleID!!.text = product.styleid;
            vax.brand!!.text = product.brand;
            vax.price!!.text = product.price.toString();
            vax.info!!.text = product.product_info;
        }

        return cvv;
    }

    internal inner class ViewAx{
        var imageView : ImageView ?= null;
        var styleID : TextView ?= null;
        var brand : TextView ?= null;
        var price : TextView ?= null;
        var info : TextView ?= null;
    }

}