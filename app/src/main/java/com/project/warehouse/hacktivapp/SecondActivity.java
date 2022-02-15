package com.project.warehouse.hacktivapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements VersionClickListener {

    RecyclerView recyclerView;
    ItemAndroidAdapter adapter;

    List<AndroidVersion> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = findViewById(R.id.recycler_view);

        adapter = new ItemAndroidAdapter();
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        AndroidVersion cupcake = new AndroidVersion("Cupcake", "https://colekcolek.com/wp-content/uploads/2012/02/android-cupcake.jpg", "health");
        AndroidVersion donut = new AndroidVersion("Donut", "https://static.wikia.nocookie.net/android/images/f/f4/Androiddonut.jpg/revision/latest?cb=20111216213427", "phone");
        AndroidVersion eclair = new AndroidVersion("Eclair", "https://i0.wp.com/salamadian.com/wp-content/uploads/2020/06/urutan-versi-android-E-2.jpg?ssl=1", "");
        AndroidVersion froyo = new AndroidVersion("Froyo", "https://www.cnet.com/a/img/ealrkjnVoo0IX2l6F7_1oxOwwrU=/940x0/2010/06/30/667454b9-cc2e-11e2-9a4a-0291187b029a/android-22_1.jpg", "");
        AndroidVersion gingerbread = new AndroidVersion("Gingerbread", "https://thumbs.dreamstime.com/b/android-gingerbread-flat-design-android-gingerbread-flat-vector-99173593.jpg", "");

        list.add(cupcake);
        list.add(donut);
        list.add(eclair);
        list.add(froyo);
        list.add(gingerbread);

        adapter.setItems(list);
    }

    @Override
    public void openDetail(AndroidVersion androidVersion) {
        Toast.makeText(this, androidVersion.getName(), Toast.LENGTH_SHORT).show();
    }
}