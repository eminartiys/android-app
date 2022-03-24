package com.project.warehouse.hacktivapp.entrance;

import android.content.Intent;
import android.os.Bundle;

import com.project.warehouse.hacktivapp.R;
import com.project.warehouse.hacktivapp.login.LoginActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

public class EntranceActivity extends AppCompatActivity {

    AppCompatButton btnLogin;
    AppCompatTextView uiViewRegister;
    AppCompatTextView uiViewAdminLogin;
    AppCompatTextView uiViewStaffLogin;
    AppCompatTextView uiViewAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        btnLogin = findViewById(R.id.btn_login);
        uiViewRegister = findViewById(R.id.ui_view_register);
        uiViewAdminLogin = findViewById(R.id.ui_view_admin_login);
        uiViewStaffLogin = findViewById(R.id.ui_view_staff_login);
        uiViewAbout = findViewById(R.id.ui_view_about);

        btnLogin.setOnClickListener(v -> gotoLogin());
        uiViewRegister.setOnClickListener(v -> gotoRegister());
        uiViewAdminLogin.setOnClickListener(v -> gotoLogin());
        uiViewStaffLogin.setOnClickListener(v -> gotoLogin());
        uiViewAbout.setOnClickListener(v -> gotoAbout());
    }

    private void gotoLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void gotoRegister() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void gotoAbout() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
