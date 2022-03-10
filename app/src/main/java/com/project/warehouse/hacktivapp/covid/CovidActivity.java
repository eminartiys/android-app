package com.project.warehouse.hacktivapp.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.model.CovidCaseResponse;
import com.project.warehouse.hacktivapp.network.RetrofitClient;

public class CovidActivity extends AppCompatActivity {

    AppCompatTextView uiViewTotalCase;
    AppCompatTextView uiViewRecoveredCase;
    AppCompatTextView uiViewDeathCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);

        uiViewTotalCase = findViewById(R.id.ui_view_total_case);
        uiViewRecoveredCase = findViewById(R.id.ui_view_total_recovered);
        uiViewDeathCase = findViewById(R.id.ui_view_total_deaths);

        getAllCases();
    }

    private void getAllCases() {
        Call<CovidCaseResponse> call = RetrofitClient.getInstance().getMyAPI().getAllCases();
        call.enqueue(new Callback<CovidCaseResponse>() {
            @Override
            public void onResponse(Call<CovidCaseResponse> call, Response<CovidCaseResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    CovidCaseResponse covidCaseResponse = response.body();
                    uiViewTotalCase.setText(String.valueOf(covidCaseResponse.cases).concat(" cases"));
                    uiViewRecoveredCase.setText(String.valueOf(covidCaseResponse.recovered).concat(" cases"));
                    uiViewDeathCase.setText(String.valueOf(covidCaseResponse.deaths).concat(" cases"));
                }
            }

            @Override
            public void onFailure(Call<CovidCaseResponse> call, Throwable t) {

            }
        });
    }
}