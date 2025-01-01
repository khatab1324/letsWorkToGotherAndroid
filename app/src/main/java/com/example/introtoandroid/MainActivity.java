package com.example.introtoandroid;


import android.content.Context;

import android.graphics.Canvas;

import android.graphics.Color;

import android.graphics.Paint;

import android.util.Log;
import android.view.View;

import android.widget.LinearLayout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.introtoandroid.Model.DatabaseSeeder;
import com.example.introtoandroid.Model.Entity.Task;
import com.example.introtoandroid.Model.Entity.Team;
import com.example.introtoandroid.Model.Entity.User;
import com.example.introtoandroid.Model.TaskRepo;
import com.example.introtoandroid.Model.TeamRepo;
import com.example.introtoandroid.Model.UserCallback;
import com.example.introtoandroid.Model.UserRepo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private DatabaseReference database;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        database = FirebaseDatabase.getInstance().getReference();
//        database.child("message").setValue("Hello, Firebase!").addOnSuccessListener(aVoid -> {
//            Log.d("Firebase", "Data written successfully.");
//        }).addOnFailureListener(e -> {
//            Log.e("Firebase", "Failed to write data.", e);
//        });
//        User newUser = new User("123", "khattab", "123", new ArrayList<>());
//        UserRepo userRepo = new UserRepo();
//        userRepo.createUser(newUser);
//        User updateUser = new User("123", "jmail", "12334", new ArrayList<>());

//        userRepo.updateUser("123",updateUser);
//        userRepo.getUser(newUser.getId(), new UserCallback() {
//            @Override
//            public void onCallback(User user) {
//                if (user != null) {
//                    Log.d("UserRepo", "Retrieved User: " + user.getUsername());
//                    Log.d("UserRepo", "Retrieved User: " + user.getPassword());
//                    Log.d("UserRepo", "Retrieved User: " + user.getId());
//                } else {
//                    Log.d("UserRepo", "User not found.");
//                }
//            }
//            @Override
//            public void onError(String error) {
//                Log.e("UserRepo", "Error retrieving user: " + error);
//            }
//        });
        DatabaseSeeder seeder = new DatabaseSeeder();
        seeder.seedDatabase(task -> {
            if (task.isSuccessful()) {
                Log.d("Seeder", "Database seeded successfully");
            } else {
                Log.e("Seeder", "Error seeding database", task.getException());
            }
        });
        super.onCreate(savedInstanceState);
    }
}