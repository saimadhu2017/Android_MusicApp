package com.saimadhukalluri.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText et_phone;
    EditText et_password;
    Button b_login;
    TextView tv_forgotPassword;
    TextView tv_register;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        setTitle("Login");
        Intent loginToHome = new Intent(this, Home.class);
        sharedPreferences = getSharedPreferences(getString(R.string.sharedPreferencefile), MODE_PRIVATE);
        boolean isLogin = sharedPreferences.getBoolean("isLogin", false);

        if (isLogin) {
            startActivity(loginToHome);
            finish();
        }

        et_phone = findViewById(R.id.et_phone);
        et_password = findViewById(R.id.et_password);
        b_login = findViewById(R.id.b_login);
        tv_forgotPassword = findViewById(R.id.tv_forgotPassword);
        tv_register = findViewById(R.id.tv_register);

        b_login.setOnClickListener(v -> {
            String phoneNumber = et_phone.getText().toString();
            String password = et_password.getText().toString();
            if (phoneNumber.equals("9542035897") && password.equals("saimadhu2017")) {
                Toast.makeText(this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                sharedPreferences.edit().putBoolean("isLogin",true).apply();
                startActivity(loginToHome);
                finish();
            } else {
                Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show();
            }
        });

        tv_forgotPassword.setOnClickListener(v -> {
            Intent loginToForgot = new Intent(this,Forgot.class);
            startActivity(loginToForgot);
        });
        tv_register.setOnClickListener(v -> {
            Intent loginToRegister = new Intent(this,Register.class);
            startActivity(loginToRegister);
        });
    }

}