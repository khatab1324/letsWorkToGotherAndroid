package com.example.introtoandroid;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.RadioGroup;
//import android.widget.Toast;
//
//public class MainActivity extends AppCompatActivity {
//    private String[] names = {"khattab", "khaled", "marwan"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ListView listView = findViewById(R.id.city_name);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getBaseContext(), "you are in the city number :" + i, Toast.LENGTH_SHORT).show();
//            }
//        });
//        ListView listViewFriend = findViewById(R.id.friends_name);
//        ArrayAdapter namesAdapter= new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,names);
//        listViewFriend.setAdapter(namesAdapter);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//    }
//}
//package com.example.trafficsign;



import android.content.Context;

import android.graphics.Canvas;

import android.graphics.Color;

import android.graphics.Paint;

import android.util.Log;
import android.view.View;

import android.widget.LinearLayout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    private DatabaseReference database;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        database = FirebaseDatabase.getInstance().getReference();
        database.child("message").setValue("Hello, Firebase!")
                .addOnSuccessListener(aVoid -> {
                    Log.d("Firebase", "Data written successfully.");
                })
                .addOnFailureListener(e -> {
                    Log.e("Firebase", "Failed to write data.", e);
                });
        super.onCreate(savedInstanceState);



        // Create a custom view to draw the traffic light

        TrafficLightView trafficLightView = new TrafficLightView(this);

        setContentView(trafficLightView);

    }



    private class TrafficLightView extends View {

        private Paint paint;



        public TrafficLightView(Context context) {

            super(context);

            paint = new Paint();

        }



        @Override

        protected void onDraw(Canvas canvas) {

            super.onDraw(canvas);
            canvas.drawColor(Color.WHITE);

            paint.setColor(Color.BLACK);

            int rectLeft = getWidth() / 2 - 150;

            int rectTop = 200;

            int rectRight = getWidth() / 2 + 150;

            int rectBottom = 1000;

            canvas.drawRect(rectLeft, rectTop, rectRight, rectBottom, paint);


            paint.setColor(Color.RED);

            canvas.drawCircle(getWidth() / 2, rectTop + 150, 100, paint);

            paint.setColor(Color.YELLOW);

            canvas.drawCircle(getWidth() / 2, rectTop + 400, 100, paint);


            paint.setColor(Color.GREEN);

            canvas.drawCircle(getWidth() / 2, rectTop + 650, 100, paint);

            paint.setColor(Color.BLACK);
             rectLeft = getWidth() / 2 - 50;

             rectTop = 1000;

             rectRight = getWidth() / 2 + 50;

             rectBottom = 1300;
            canvas.drawRect(rectLeft, rectTop, rectRight, rectBottom, paint);
        }

    }
}