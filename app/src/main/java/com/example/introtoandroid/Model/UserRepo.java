package com.example.introtoandroid.Model;

import androidx.annotation.NonNull;

import com.example.introtoandroid.Model.Entity.Team;
import com.example.introtoandroid.Model.Entity.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private DatabaseReference dbRef;

    public UserRepo() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("users");
    }


    public void createUser(User user) {
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(dbRef.push().getKey());
        }
        dbRef.child(user.getId()).setValue(user);
    }

    public void getUser(String userId, UserCallback callback) {
        dbRef.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                //this will convert data that in firebase to obj
                callback.onCallback(user);//send the user obj back
            }

            @Override
            public void onCancelled(DatabaseError error) {
                callback.onError(error.getMessage());
            }
        });
    }

    public void updateUser(String userId, User updatedUser) {
        dbRef.child(userId).setValue(updatedUser);
    }

    public void deleteUser(String userId) {
        dbRef.child(userId).removeValue();
    }

    public void getTeamsFromUser(String userId, TeamsCallback callback) {
        dbRef.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Team> teams = new ArrayList<>();
                User user= (User)dataSnapshot.getChildren();
                for (Team team :user.getTeams()) {
                    teams.add(team);
                }
                callback.onCallback(teams);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                callback.onError(databaseError.getMessage());
            }
        });
    }

}

