package com.example.myapplication.tuan2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Tuan21MainActivity extends AppCompatActivity {

    EditText txt1, txt2;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tuan21_main);
        txt1 = findViewById(R.id.tuan21txt1);
        txt2 = findViewById(R.id.tuan21txt2);
        btn1 = findViewById(R.id.tuan21btn1);
        // su kien khi click button1
        btn1.setOnClickListener(v->{
            // 1. dinh huong di chuyen
            Intent i = new Intent(Tuan21MainActivity.this,Tuan22MainActivity.class);
            //2. Đưa dữ liệu vào.
            i.putExtra("So 1", txt1.getText().toString());
            i.putExtra("So 2", txt2.getText().toString());
            // 3. Khoi hanh
            startActivity(i);

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}