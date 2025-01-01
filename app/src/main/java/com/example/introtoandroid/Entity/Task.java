package com.example.introtoandroid.Entity;

import java.util.Date;

public class Task {
     String id;
     String name;
     String description;
     Priority priority;
     Date endLine;

    // Enum for priority
    public enum Priority {
        LOW, MEDIUM, HIGH;
    }

    // Getters and setters
}