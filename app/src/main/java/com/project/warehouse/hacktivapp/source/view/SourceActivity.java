package com.project.warehouse.hacktivapp.source.view;

import android.os.Bundle;
import android.util.Log;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.model.Source;
import com.project.warehouse.hacktivapp.model.SourceResponse;
import com.project.warehouse.hacktivapp.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SourceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SourceAdapter adapter;

    List<Source> sources = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source);

        recyclerView = findViewById(R.id.recycler_view);

        adapter = new SourceAdapter();
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        getSources();
    }

    public void getSources() {
        Call<SourceResponse> call = RetrofitClient.getInstance().getMyAPI().getSource();
        call.enqueue(new Callback<SourceResponse>() {
            @Override
            public void onResponse(Call<SourceResponse> call, Response<SourceResponse> response) {
                if (response.isSuccessful()) {
                    SourceResponse source = response.body();
                    adapter.setItems(source.sources);
                }
            }

            @Override
            public void onFailure(Call<SourceResponse> call, Throwable t) {
                Log.e("Error Call", t.getMessage());
            }
        });
    }
}