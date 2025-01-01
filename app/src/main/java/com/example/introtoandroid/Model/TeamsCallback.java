package com.example.introtoandroid.Model;

import com.example.introtoandroid.Model.Entity.Team;

import java.util.List;

public interface TeamsCallback {
    void onCallback(List<Team> teams);

    void onError(String error);
}
