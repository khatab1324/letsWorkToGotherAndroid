package com.example.introtoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.introtoandroid.Model.Entity.User;
import com.example.introtoandroid.Model.UserRepo;

import java.util.ArrayList;

public class CreateAccount extends AppCompatActivity {
    private EditText usernameField;
    private EditText passwordField;
    private EditText confirmPasswordField;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        usernameField = findViewById(R.id.username);
        passwordField = findViewById(R.id.password);
        confirmPasswordField = findViewById(R.id.confirmPassword);
        findViewById(R.id.createAccount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();
                String confirmPassword = confirmPasswordField.getText().toString().trim();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(CreateAccount.this, "Please enter username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(CreateAccount.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(CreateAccount.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }
                User newUser = new User(null, username, password, new ArrayList<>());
                UserRepo userRepo = new UserRepo();
                userRepo.createUser(newUser);

                //Todo : see if transaction success
                Intent intent = new Intent(CreateAccount.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}