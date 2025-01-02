package com.example.introtoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
    }
    public void createAccount(View view) {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
        finish();
    }
}