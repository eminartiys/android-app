package com.project.warehouse.hacktivapp.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.database.SQLiteDatabaseHandler;
import com.project.warehouse.hacktivapp.main.MainActivity;
import com.project.warehouse.hacktivapp.model.User;
import com.project.warehouse.hacktivapp.recipe.RecipeActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

public class RegisterActivity extends AppCompatActivity {

    AppCompatEditText inputUsername;
    AppCompatEditText inputName;
    AppCompatEditText inputPhoneNumber;
    AppCompatEditText inputPassword;
    AppCompatButton btnLogin;

    SQLiteDatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseHandler = new SQLiteDatabaseHandler(this);

        // Menghubungkan activity ke xml
        inputUsername = findViewById(R.id.input_username);
        inputName = findViewById(R.id.input_name);
        inputPhoneNumber = findViewById(R.id.input_phonenum);
        inputPassword = findViewById(R.id.input_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(v -> doRegister());
    }

    private void doRegister() {
        String username = inputUsername.getText().toString();
        String name = inputName.getText().toString();
        String phoneNum = inputPhoneNumber.getText().toString();
        String password = inputPassword.getText().toString();

        boolean error = false;

        if (name.isEmpty()) {
            error = true;
            inputUsername.setError("Nama tidak boleh kosong");
        }
        if (username.isEmpty()) {
            error = true;
            inputUsername.setError("Username tidak boleh kosong");
        }
        if (password.isEmpty()) {
            error = true;
            inputPassword.setError("Password tidak boleh kosong");
        }

        if (!error) {
            User user = new User();
            user.setUsername(username);
            user.setName(name);
            user.setPhoneNumber(username);
            if (user == null) {
                Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
                editor.putBoolean("IS_ALREADY_LOGIN", true);
                editor.apply();

                Intent intent = new Intent(this, RecipeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        }
    }
}