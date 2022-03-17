package com.project.warehouse.hacktivapp.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.database.SQLiteDatabaseHandler;
import com.project.warehouse.hacktivapp.main.MainActivity;
import com.project.warehouse.hacktivapp.model.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

public class LoginActivity extends AppCompatActivity {

    // tipe view      // nama view
    AppCompatEditText inputUsername;
    AppCompatEditText inputPassword;
    AppCompatButton btnLogin;

    SQLiteDatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHandler = new SQLiteDatabaseHandler(this);

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
            User user = databaseHandler.getUserByUsernameAndPassword(username, password);
            if (user == null) {
                Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
                editor.putBoolean("IS_ALREADY_LOGIN", true);
                editor.apply();

                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        }
    }
}