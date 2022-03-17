package com.project.warehouse.hacktivapp.entrance;

import android.content.Intent;
import android.os.Bundle;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.login.LoginActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class EntranceActivity extends AppCompatActivity {

    AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(v -> gotoLogin());
    }

    private void gotoLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}