package com.example.introtoandroid.Model.Entity;

import java.util.Date;

public class Task {
     String id;
     String name;
     String description;
     Priority priority;
     Date endLine;


    public enum Priority {
        secondary,normal,cruial;
    }
    public Task() {}

    public Task(String id, String name, String description, Priority priority, Date endLine) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.endLine = endLine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getEndLine() {
        return endLine;
    }

    public void setEndLine(Date endLine) {
        this.endLine = endLine;
    }
}