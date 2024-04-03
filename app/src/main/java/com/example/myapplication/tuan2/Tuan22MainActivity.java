package com.example.myapplication.tuan2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.myapplication.R;

public class Tuan22MainActivity extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tuan22_main);
        tv1 = findViewById(R.id.tuan22tv1);

        // don du lieu
        Intent i1 = getIntent();
        // dỡ hàng.
        String chuoi1 = i1.getExtras().getString("So 1");
        String chuoi2 = i1.getExtras().getString("So 2");

        float so1 = Float.parseFloat(chuoi1);
        float so2 = Float.parseFloat(chuoi2);
        float tong = so1+so2;

        // hien thi ket qua
        tv1.setText(String.valueOf(tong));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}