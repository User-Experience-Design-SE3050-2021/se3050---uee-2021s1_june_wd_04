package com.example.topjobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.topjobapp.UserManagement_Profile.welcome_page;

public class on_boarding_page1 extends AppCompatActivity {

    private Button start, skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_page1);

        start = findViewById(R.id.u_button2);
        skip = findViewById(R.id.u_skip);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(on_boarding_page1.this, on_board_page2.class));
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(on_boarding_page1.this, welcome_page.class));
            }
        });
    }
}