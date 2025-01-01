package com.example.introtoandroid.Model;

import com.example.introtoandroid.Model.Entity.User;

import java.util.List;

public interface UsersCallback {
    void onCallback(List<User> users);

    void onError(String error);
}
