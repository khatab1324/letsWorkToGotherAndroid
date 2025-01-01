package com.example.introtoandroid.Model;

import com.example.introtoandroid.Model.Entity.Task;

import java.util.List;

public interface TaskCallback {
    void onCallback(Task task);

    void onError(String error);
}
