package com.project.warehouse.hacktivapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAndroidAdapter adapter;

    List<AndroidVersion> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = findViewById(R.id.recycler_view);

        adapter = new ItemAndroidAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        AndroidVersion cupcake = new AndroidVersion("Cupcake", R.mipmap.ic_launcher);
        AndroidVersion donut = new AndroidVersion("Donut", R.drawable.ic_launcher_foreground);
        AndroidVersion eclair = new AndroidVersion("Eclair", R.mipmap.ic_launcher);
        AndroidVersion froyo = new AndroidVersion("Froyo", R.drawable.ic_launcher_foreground);
        AndroidVersion gingerbread = new AndroidVersion("Gingerbread", R.mipmap.ic_launcher);

        list.add(cupcake);
        list.add(donut);
        list.add(eclair);
        list.add(froyo);
        list.add(gingerbread);

        adapter.setItems(list);
    }
}