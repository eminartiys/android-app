package com.project.warehouse.hacktivapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

public class MainActivity extends AppCompatActivity {

    String input_username;

    // tipe view      // nama view
    AppCompatEditText inputUsername;
    AppCompatEditText inputPassword;
    AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menghubungkan activity ke xml
        inputUsername = findViewById(R.id.input_username);
        inputPassword = findViewById(R.id.input_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(v -> doLogin());
    }

    private void doLogin() {
        String username = inputUsername.getText().toString();
        String password = inputPassword.getText().toString();

        if (username.isEmpty() && password.isEmpty()) {
            inputUsername.setError("Username tidak boleh kosong");
            inputPassword.setError("Password tidak boleh kosong");
        } else if (username.isEmpty()) {
            inputUsername.setError("Username tidak boleh kosong");
        } else if (password.isEmpty()) {
            inputPassword.setError("Password tidak boleh kosong");
        } else {
            // send value to SecondActivity
            Intent secondScreen = new Intent(this, SecondActivity.class);
            secondScreen.putExtra("SEND", username);
            startActivity(secondScreen);
        }
    }
}