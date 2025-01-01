package com.example.introtoandroid.Model.Entity;

import java.util.List;

public class Team {
    private String id;
    private String name;
    private List<User> users;
    private List<Task> tasks;

    public  Team(){}


    public  Team(String id, String name, List<User> users, List<Task> tasks) {
        this.id=id;
        this.name=name;
        this.users=users;
        this.tasks=tasks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}