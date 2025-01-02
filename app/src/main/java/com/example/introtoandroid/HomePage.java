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

public class HomePage extends AppCompatActivity {

    private LinearLayout mainLayout;
    private LinearLayout ButtonsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create main layout
        RelativeLayout mainLayout = new RelativeLayout(this);
        mainLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));

        // Create Join button
        Button join = new Button(this);
        join.setId(View.generateViewId());
        join.setText("Join");
        join.setBackgroundColor(Color.BLACK);
        join.setTextColor(Color.WHITE);
        join.setBackgroundResource(R.drawable.rectangle3);

        RelativeLayout.LayoutParams joinParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        joinParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        joinParams.topMargin = 16;
        join.setLayoutParams(joinParams);

        // Create back button
        ImageButton back = new ImageButton(this);
        back.setBackgroundResource(R.drawable.back_icon);
        RelativeLayout.LayoutParams backParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        backParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        backParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        back.setLayoutParams(backParams);
        back.setOnClickListener(v -> finish());

        // Create ListView
        ListView listView = new ListView(this);
        List<String> listData = new ArrayList<>();
        listData.add("Item 1");
        listData.add("Item 2");
        listData.add("Item 3");



        MyCustomAdapter adapter = new MyCustomAdapter(this, listData);
        listView.setAdapter(adapter);

        RelativeLayout.LayoutParams listParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        listParams.addRule(RelativeLayout.BELOW, join.getId());
        listParams.topMargin = 16;
        listView.setLayoutParams(listParams);

        // Create plus button with bottom-right positioning
        // Create plus button with bottom-right positioning
        ImageButton plus = new ImageButton(this);
        plus.setBackgroundResource(R.drawable.plus_button);

// Define specific size for the button (50px width and height)
        RelativeLayout.LayoutParams plusParams = new RelativeLayout.LayoutParams(50, // Width in pixels
                50  // Height in pixels
        );

// Position the button at the bottom-right corner
        plusParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        plusParams.addRule(RelativeLayout.ALIGN_PARENT_END);

// Add some margin from the bottom and right edges
        plusParams.bottomMargin = 32; // Adjust margin as needed
        plusParams.rightMargin = 32;  // Adjust margin as needed

// Apply the layout parameters to the button
        plus.setLayoutParams(plusParams);

// Set an OnClickListener to handle button clicks
        plus.setOnClickListener(v -> {
            // Add your click handling logic here
        });


        // Add all views to the main layout
        mainLayout.addView(back);
        mainLayout.addView(join);
        mainLayout.addView(listView);
        mainLayout.addView(plus);  // Add plus button last so it appears on top

        // Set the content view
        setContentView(mainLayout);
    }
}