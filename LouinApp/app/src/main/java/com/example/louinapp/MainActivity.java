package com.example.louinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.louinapp.Adapter.ProductAdapter;
import com.example.louinapp.Model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Product> productArrayList;
    private static ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        productArrayList = new ArrayList<>();

        Product product1 = new Product("Kacang Garuda 300g", 30000, R.drawable.garuda);
        Product product2 = new Product("HIT Electric", 20000, R.drawable.hit);
        Product product3 = new Product("Aqua 300ml", 5000, R.drawable.aqua);
        Product product4 = new Product("Pocari Sweat 250ml", 10000, R.drawable.pocari);
        Product product5 = new Product("Indomie Kari Ayam 150g", 3000, R.drawable.indomie);
        Product product6 = new Product("Ultra Milk 500ml", 15000, R.drawable.ultra);
        Product product7 = new Product("Minyak Goreng Sania 2L", 20000, R.drawable.sania);
        Product product8 = new Product("Minyak Goreng Tropical 2L", 20000, R.drawable.tropical);

        productArrayList.add(product1);
        productArrayList.add(product2);
        productArrayList.add(product3);
        productArrayList.add(product4);
        productArrayList.add(product5);
        productArrayList.add(product6);
        productArrayList.add(product7);
        productArrayList.add(product8);

        adapter = new ProductAdapter(productArrayList, getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(
                        MainActivity.this,
                        "Selected product : " + adapter.getItem(i).getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}