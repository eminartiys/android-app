package com.project.warehouse.hacktivapp.splashscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.database.SQLiteDatabaseHandler;
import com.project.warehouse.hacktivapp.entrance.EntranceActivity;
import com.project.warehouse.hacktivapp.main.MainActivity;
import com.project.warehouse.hacktivapp.model.User;
import com.project.warehouse.hacktivapp.recipe.RecipeActivity;

import androidx.appcompat.app.AppCompatActivity;

public class SplashscreenActivity extends AppCompatActivity {

    SQLiteDatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        databaseHandler = new SQLiteDatabaseHandler(this);
        createUser();

        Handler handler = new Handler();
        handler.postDelayed(this::navigateTo, 5000);
    }

    private void createUser() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isAdminAlreadyCreate = sharedPreferences.getBoolean("IS_ADMIN_ALREADY_CREATE", false);

        if (!isAdminAlreadyCreate) {
            User admin = new User("admin", "admin", "0812345678", "123456");
            User staff = new User("staff", "staff", "0812345678", "123456");

            databaseHandler.addUser(admin);
            databaseHandler.addUser(staff);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("IS_ADMIN_ALREADY_CREATE", true);
            editor.apply();
        }
    }

    private void navigateTo() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isLogin = sharedPreferences.getBoolean("IS_ALREADY_LOGIN", false);

        if (isLogin) {
            navigateToMainActivity();
        } else {
            navigateToLoginActivity();
        }
    }

    private void navigateToLoginActivity() {
        Intent intent = new Intent(this, EntranceActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(this, RecipeActivity.class);
        startActivity(intent);
        finish();
    }

}
