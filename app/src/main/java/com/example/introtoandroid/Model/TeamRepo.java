package com.example.introtoandroid.Model;

import androidx.annotation.NonNull;

import com.example.introtoandroid.Model.Entity.Task;
import com.example.introtoandroid.Model.Entity.Team;
import com.example.introtoandroid.Model.Entity.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TeamRepo {
    private DatabaseReference dbRef;


    public  TeamRepo() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("teams");
    }

    public void createTeam(Team team) {
        if (team.getId() == null || team.getId().isEmpty()) {
            team.setId(dbRef.push().getKey());
        }
        dbRef.child(team.getId()).setValue(team);
    }

    public void getTeam(String teamId, UserCallback callback) {
        dbRef.child(teamId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                callback.onCallback(user);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                callback.onError(error.getMessage());
            }
        });
    }

    public void updateTeam(String userId, Team updatedTeam) {
        dbRef.child(userId).setValue(updatedTeam);
    }

    public void deleteTeam(String teamId) {
        dbRef.child(teamId).removeValue();
    }

    public void getUsersFromTeam(String teamId, UsersCallback callback) {
        dbRef.child(teamId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<User> users = new ArrayList<>();
                Team team = (Team) dataSnapshot.getChildren();
                for (User user : team.getUsers()) {
                    users.add(user);
                }
                callback.onCallback(users);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                callback.onError(databaseError.getMessage());
            }
        });
    }
    public void getTaskFromTeams(String teamId, TasksCallback callback) {
        dbRef.child(teamId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Task> tasks = new ArrayList<>();
                Team team = (Team) dataSnapshot.getChildren();
                for (Task task : team.getTasks()) {
                    tasks.add(task);
                }
                callback.onCallback(tasks);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                callback.onError(databaseError.getMessage());
            }
        });
    }
}
