package com.example.introtoandroid.Model;

import com.example.introtoandroid.Model.Entity.User;
import com.example.introtoandroid.Model.Entity.Team;
import com.example.introtoandroid.Model.Entity.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Date;

public class DatabaseSeeder {
    private final UserRepo userRepo;
    private final TeamRepo teamRepo;
    private final TaskRepo taskRepo;

    public DatabaseSeeder() {
        userRepo = new UserRepo();
        teamRepo = new TeamRepo();
        taskRepo = new TaskRepo();
    }

    public void seedDatabase(OnCompleteListener<Void> onComplete) {
        FirebaseDatabase.getInstance().getReference().removeValue().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                createSeedData();
                if (onComplete != null) {
                    onComplete.onComplete(task);
                }
            }
        });
    }

    private void createSeedData() {
        // Create Users
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            User user = new User();
            user.setId("user" + i);
            user.setUsername("user" + i);
            user.setPassword("password" + i);
            users.add(user);
            userRepo.createUser(user);
        }

        // Create Teams
        List<Team> teams = new ArrayList<>();
        String[] teamNames = {"Development", "Design", "Marketing"};
        for (int i = 0; i < teamNames.length; i++) {
            Team team = new Team();
            team.setId("team" + (i + 1));
            team.setName(teamNames[i]);
            teams.add(team);
            teamRepo.createTeam(team);
        }

        // Create user-team relationships in a separate node
        DatabaseReference relationshipsRef = FirebaseDatabase.getInstance().getReference("relationships");

        for (int i = 0; i < users.size(); i++) {
            String userId = users.get(i).getId();
            String teamId = teams.get(i % teams.size()).getId();

            // Store user-team relationship
            Map<String, Object> relationship = new HashMap<>();
            relationship.put("userId", userId);
            relationship.put("teamId", teamId);

            relationshipsRef.child("user_teams").push().setValue(relationship);
        }

        // Create Tasks
        String[][] taskData = {
                {"Setup Database", "Configure Firebase Realtime Database", "cruial"},
                {"Design UI", "Create user interface mockups", "normal"},
                {"User Testing", "Conduct user acceptance testing", "secondary"}
        };

        for (int i = 0; i < taskData.length; i++) {
            Task task = new Task();
            task.setId("task" + (i + 1));
            task.setName(taskData[i][0]);
            task.setDescription(taskData[i][1]);
            task.setPriority(Task.Priority.valueOf(taskData[i][2]));
            task.setEndLine(new Date(System.currentTimeMillis() + ((i + 1) * 86400000)));

            taskRepo.createTask(task);

            // Store task-team relationship
            String teamId = teams.get(i % teams.size()).getId();
            Map<String, Object> taskTeamRel = new HashMap<>();
            taskTeamRel.put("taskId", task.getId());
            taskTeamRel.put("teamId", teamId);

            relationshipsRef.child("team_tasks").push().setValue(taskTeamRel);
        }
    }
}