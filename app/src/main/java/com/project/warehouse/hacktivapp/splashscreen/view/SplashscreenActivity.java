package com.project.warehouse.hacktivapp.splashscreen.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.project.warehouse.hacktivapp.MainActivity;
import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.database.SQLiteDatabaseHandler;
import com.project.warehouse.hacktivapp.login.view.LoginActivity;
import com.project.warehouse.hacktivapp.model.User;

import androidx.appcompat.app.AppCompatActivity;

public class SplashscreenActivity extends AppCompatActivity {

    SQLiteDatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        databaseHandler = new SQLiteDatabaseHandler(this);

        // navigate to
        createUser();
        navigateTo();
    }

    private void navigateTo() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isLogin = sharedPreferences.getBoolean("IS_LOGIN", false);

        if (isLogin) {
            navigateToMainActivity();
        } else {
            navigateToLoginActivity();
        }
    }

    private void navigateToLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void createUser() {
        User admin = new User("admin", "Admin", "admin123");
        databaseHandler.addUser(admin);

        User staff = new User("staff", "Staff", "staff123");
        databaseHandler.addUser(staff);
    }
}