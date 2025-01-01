package com.example.introtoandroid.Model;

import com.example.introtoandroid.Model.Entity.User;

public interface UserCallback {
    void onCallback(User user);

    void onError(String error);
}
