package com.example.introtoandroid;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TeamScreen extends AppCompatActivity {

    private LinearLayout mainLayout;
    private LinearLayout ButtonsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout mainLayout = new RelativeLayout(this);

        ImageButton share =new ImageButton(this);
        share.setBackgroundResource(R.drawable.share1);
        share.setId(View.generateViewId());

        ImageButton settings =new ImageButton(this);
        settings.setBackgroundResource(R.drawable.settings);

        ImageButton back = new ImageButton(this);
        back.setBackgroundResource(R.drawable.back_icon);
        back.setId(View.generateViewId());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView teamName = new TextView(this);
        teamName.setText("Team 1");
        teamName.setTextSize(50);
        teamName.setGravity(Gravity.CENTER);
        teamName.setId(View.generateViewId());

        ImageButton plus = new ImageButton(this);
        plus.setBackgroundResource(R.drawable.plus_button);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ListView listView = new ListView(this);
        List<String> listData = new ArrayList<>();
        listData.add("Item 1");
        listData.add("Item 2");
        listData.add("Item 3");

        TasksList adapter = new TasksList(this, listData);
        listView.setAdapter(adapter);

        RelativeLayout.LayoutParams shareParams = new RelativeLayout.LayoutParams(
                120, 120
        );
        shareParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        shareParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        shareParams.setMargins(5, 30, 30, 30);

        RelativeLayout.LayoutParams settingsParams = new RelativeLayout.LayoutParams(
                100, 100
        );
        settingsParams.addRule(RelativeLayout.LEFT_OF, share.getId());
        settingsParams.setMargins(30, 40, 5, 30);

        RelativeLayout.LayoutParams backParams = new RelativeLayout.LayoutParams(
                100, 100
        );
        backParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        backParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        backParams.setMargins(20, 20, 20, 20);

        RelativeLayout.LayoutParams teamNameParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        teamNameParams.addRule(RelativeLayout.BELOW, back.getId());
        teamNameParams.setMargins(30, 40, 5, 30);

        RelativeLayout.LayoutParams plusParams = new RelativeLayout.LayoutParams(
                120, 120
        );
        plusParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        plusParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        plusParams.setMargins(20, 20, 50, 100);

        RelativeLayout.LayoutParams listParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        listParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        listParams.addRule(RelativeLayout.BELOW, teamName.getId());

        mainLayout.addView(share,shareParams);
        mainLayout.addView(settings,settingsParams);
        mainLayout.addView(back, backParams);
        mainLayout.addView(listView, listParams);
        mainLayout.addView(plus, plusParams);
        mainLayout.addView(teamName, teamNameParams);
        setContentView(mainLayout);
    }
}