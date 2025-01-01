package com.example.introtoandroid.Model.Entity;

import java.util.Date;
import java.util.List;

public class User {
     String  id ;
     String username;
     String password;

     List<Team> teams ;
     public  User(){}


     public User(String id, String username, String password, List<Team> teams) {
          this.id = id;
          this.username = username;
          this.password=password;
          this.teams=teams;
     }
     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public void setTeams(List<Team> teams) {
          this.teams = teams;
     }

     public List<Team> getTeams() {
          return teams;
     }
}
