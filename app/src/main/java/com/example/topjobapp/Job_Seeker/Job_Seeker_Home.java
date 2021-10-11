package com.example.topjobapp.Job_Seeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


import com.example.topjobapp.JobProvider_viewJobVacancy_JS;

import com.example.topjobapp.JobProvider_home;

import com.example.topjobapp.R;
import com.example.topjobapp.UserManagement_Profile.JobSeeker_login;

import com.example.topjobapp.UserManagement_Profile.welcome_page;

import com.example.topjobapp.UserManagement_Profile.Job_Provider_Profile;
import com.example.topjobapp.UserManagement_Profile.Job_Seeker_Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Job_Seeker_Home extends AppCompatActivity {

    private ImageView jobVacancy;
    private ImageView addApplicant;

    private ImageButton back;

    private BottomNavigationView bottomnav;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker_home);

        jobVacancy = findViewById(R.id.job_vacancies_image);

        back = findViewById(R.id.backbtn1);

        bottomnav = findViewById(R.id.u_navr);


        jobVacancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Job_Seeker_Home.this, JobProvider_viewJobVacancy_JS.class));
            }
        });

        addApplicant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Job_Seeker_Home.this, RetrieveAllApplicants.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Job_Seeker_Home.this, welcome_page.class));
            }
        });

        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home1:
                        Intent intent = new Intent(Job_Seeker_Home.this, Job_Seeker_Home.class);
                        startActivity(intent);
                        // do something here
                        return true;
                    case R.id.navigation_notification:
                        // do something here
                        return true;
                    case R.id.navigation_profile:
                        Intent intents = new Intent(Job_Seeker_Home.this, Job_Seeker_Profile.class);
                        startActivity(intents);

                        // do something here
                        return true;
                    default: return true;
                }
            }
        });
    }
}