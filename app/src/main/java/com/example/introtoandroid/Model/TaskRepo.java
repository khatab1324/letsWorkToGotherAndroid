package com.example.introtoandroid.Model;

import androidx.annotation.NonNull;

import com.example.introtoandroid.Model.Entity.Task;
import com.example.introtoandroid.Model.Entity.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TaskRepo {
    private DatabaseReference dbRef;

    public TaskRepo() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("tasks");
    }

    public void createTask(Task task) {
        if (task.getId() == null || task.getId().isEmpty()) {
            task.setId(dbRef.push().getKey());
        }
        dbRef.child(task.getId()).setValue(task);
    }

    public void getTask(String taskId, TaskCallback taskCallback) {
        dbRef.child(taskId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Task task = dataSnapshot.getValue(Task.class);
                taskCallback.onCallback(task);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                taskCallback.onError(databaseError.getMessage());
            }
        });
    }

    public void updateTask(String taskId, Task updatedTask) {
        dbRef.child(taskId).setValue(updatedTask);
    }

    public void removeTask(String taskId) {
        dbRef.child(taskId).removeValue();
    }

    public void getTasks(TasksCallback taskCallback) {
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Task> tasksList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Task task = snapshot.getValue(Task.class);
                    tasksList.add(task);
                }
                taskCallback.onCallback(tasksList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                taskCallback.onError(databaseError.getMessage());
            }
        });
    }


}

