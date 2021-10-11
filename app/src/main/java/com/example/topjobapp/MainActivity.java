package com.example.topjobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

//    private ImageButton welcome;


    private static int SPLASH_TIME_OUT = 4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        new Handler().postDelayed(new Runnable() {
            @Override

        public void run() {
            Intent homeIntent = new Intent(MainActivity.this, on_boarding_page1.class);
            startActivity(homeIntent);
            finish();

        }
    }, SPLASH_TIME_OUT);

//
//        welcome = findViewById(R.id.u_tapbtn1);
//
//        welcome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, on_boarding_page1.class));
//            }
//        });
    }
}