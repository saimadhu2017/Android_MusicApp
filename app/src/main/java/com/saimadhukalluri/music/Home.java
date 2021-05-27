package com.saimadhukalluri.music;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    Button b_logout;
    String tittleOfTool;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        sharedPreferences = getSharedPreferences(getString(R.string.sharedPreferencefile), MODE_PRIVATE);
        tittleOfTool = sharedPreferences.getString("homeTitle", "Home");
        setTitle(tittleOfTool);

        b_logout=findViewById(R.id.b_logout);
        b_logout.setOnClickListener(v -> {
            sharedPreferences.edit().clear().apply();
            Intent toLoginPage=new Intent(this,Login.class);
            startActivity(toLoginPage);
            finish();
        });
    }
}