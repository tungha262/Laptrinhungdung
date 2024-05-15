package com.example.myapplication.tuan6;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class T6MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProductAdapter adapter;
    private List<Product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_t6_main);
        listView = findViewById(R.id.t6_list_view);
        productList = new ArrayList<>();
        adapter = new ProductAdapter(this,productList);
        listView.setAdapter(adapter);

        // get data from API
        new FetchProductTask().execute();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private class FetchProductTask extends AsyncTask<Void,Void,String>{
        // get data from API
        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder response = new StringBuilder(); // save result
            try {
                URL url = new URL("https://hungnttg.github.io/shopgiay.json"); // url
                HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // open url

                // set method
                connection.setRequestMethod("GET");

                // CREATE buffer for read data
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                // read data

                String line = "";
                while ((line = reader.readLine())!= null){
                    response.append(line);
                }
                reader.close();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return response.toString();
        }
        // return data for client
        @Override
        protected void onPostExecute(String s) {
            if(s != null && !s.isEmpty()){
                try {
                    JSONObject json = new JSONObject(s);
                    JSONArray productArray = json.getJSONArray("products");
                    for(int i = 0; i < productArray.length(); i++){
                        JSONObject productObject = productArray.getJSONObject(i);
                        String styleID = productObject.getString("styleid");
                        String brand = productObject.getString("brands_filter_facet");
                        String price = productObject.getString("price");
                        String additionalInfo = productObject.getString("product_additional_info");
                        String image = productObject.getString("search_image");

                        Product product = new Product(styleID, brand, price, additionalInfo, image);
                        productList.add(product);
                    }
                    adapter.notifyDataSetChanged(); // update to adapter
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }else {
                Toast.makeText(T6MainActivity.this,"Failed to fetch products!", Toast.LENGTH_LONG).show();
            }
        }
    }
}