package com.example.stotedata_cw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView RV;
    private DatabaseHelper dbHelper;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dbHelper = new DatabaseHelper(this);

        RV = findViewById(R.id.DetailRV);
        RV.setHasFixedSize(true);
        loadData();
    }
    private void loadData() {
        adapter = new Adapter(this, dbHelper.getAllData());
        RV.setAdapter(adapter);

    }
    @Override
    protected void onResume(){
        super.onResume();
        loadData();
    }
}