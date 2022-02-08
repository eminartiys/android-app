package com.project.warehouse.hacktivapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    AppCompatTextView textHalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textHalo = findViewById(R.id.text_halo);

        // Get value from main screen
        String value = getIntent().getStringExtra("SEND");

        if (value.isEmpty()) {
            textHalo.setText("Halo");
        } else {
            textHalo.setText(value);
        }
    }
}