package com.example.topjobapp.UserManagement_Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.topjobapp.JobProvider_home;
import com.example.topjobapp.Prevalent.Prevalent;
import com.example.topjobapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Job_Seeker_Profile extends AppCompatActivity {

    private TextView name, email, dob, gender;
    private BottomNavigationView bottomnav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job__seeker__profile);

        name = findViewById(R.id.u_namet);
        email = findViewById(R.id.u_emailt);
        dob = findViewById(R.id.u_dobt);
        gender = findViewById(R.id.u_gendert);

        bottomnav = findViewById(R.id.u_nav);

        name.setText(Prevalent.currentOnlineUser.getUsername());
        email.setText(Prevalent.currentOnlineUser.getEmail());
        dob.setText(Prevalent.currentOnlineUser.getDob());
        gender.setText(Prevalent.currentOnlineUser.getGender());

        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home1:
                        Intent intent = new Intent(Job_Seeker_Profile.this, JobProvider_home.class);
                        startActivity(intent);
                        // do something here
                        return true;
                    case R.id.navigation_notification:
                        // do something here
                        return true;
                    case R.id.navigation_profile:
                        // do something here
                        return true;
                    default: return true;
                }
            }
        });

    }
}