package com.example.myapplication.tuan6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class Tuan6DetailActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tuan6_detail);
        // nhan du lieu tu listProduct chuyen sang
        Intent intent = getIntent();
        Product1 product = intent.getParcelableExtra("PRODUCT");

        // anh xa cac thanh phan len giao dien
         ImageView imgProduct = findViewById(R.id.tuan6detailimg);
        TextView tvStyleId = findViewById(R.id.tuan6detailTvStyleid);
        TextView tvPrice = findViewById(R.id.tuan6detailTvprice);
        TextView tvbrand = findViewById(R.id.tuan6detailTvbrand);
        TextView tvAdditionInfo = findViewById(R.id.tuan6detailAdditionInfo);

        // hien thi thong tin san pham
        if(product != null){
            // hien thi anh
            Picasso.get().load(product.getSearchImage())
                    .into(imgProduct);

            // hien thi text
            tvAdditionInfo.setText("Info: " + product.getAdditionalInfo());
            tvbrand.setText("Brand: " + product.getBrand());
            tvPrice.setText("Price: " + product.getPrice());
            tvStyleId.setText("StyleID: " + product.getStyleID());
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}