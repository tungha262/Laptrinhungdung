package com.example.myapplication.tuan6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ProductAdapter1 extends BaseAdapter {
    private Context mcontext;
    private List<Product1> mProductList;

    public ProductAdapter1(Context context, List<Product1> productList) {
        this.mcontext = context;
        this.mProductList = productList;
    }

    @Override

    public int getCount() {
        return mProductList.size();
    }
    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // create view
        ViewHolderT6 holder;
        if(convertView == null){
            // object generate
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.item_view_t6,parent,false);

            holder = new ViewHolderT6();
            holder.imageView = convertView.findViewById(R.id.item_product_imageView);
            holder.styleID = convertView.findViewById(R.id.item_styleIDtv);
            holder.brandTv = convertView.findViewById(R.id.item_brandtv);
            holder.pricetv = convertView.findViewById(R.id.item_pricetv);
            holder.additionalInfoTv = convertView.findViewById(R.id.item_additionalInfotv);
            convertView.setTag(holder);
        }
        else {
            holder =(ViewHolderT6) convertView.getTag();
        }

        //set data for view
        Product1 product = mProductList.get(position);
        if(product != null){
            Picasso.get().load(product.getSearchImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.imageView);

            holder.styleID.setText(product.getStyleID());
            holder.brandTv.setText(product.getBrand());
            holder.pricetv.setText(product.getPrice());
            holder.additionalInfoTv.setText(product.getAdditionalInfo());

        }
        return convertView;
    }

    static class ViewHolderT6 {
        ImageView imageView;
        TextView styleID, brandTv, pricetv, additionalInfoTv;
        }
}
