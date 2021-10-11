package com.example.topjobapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.example.topjobapp.Job_Seeker.ProvidersideAllApplicants;

import com.example.topjobapp.Job_Seeker.ApplicantsRetrieve;

import com.example.topjobapp.UserManagement_Profile.JobProvider_login;
import com.example.topjobapp.UserManagement_Profile.Job_Provider_Profile;
import com.example.topjobapp.UserManagement_Profile.Job_Seeker_Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class JobProvider_home extends AppCompatActivity {

    private Button jobVacancy;
    private Button jobList;
    private BottomNavigationView bottomnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_provider_home);



        jobVacancy = findViewById(R.id.j_button2);
        bottomnav = findViewById(R.id.u_navs);

        jobVacancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JobProvider_home.this, View_JobList.class));
            }
        });



//        jobList = findViewById(R.id.j_button1);
//
//
//        jobList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(JobProvider_home.this, ApplicantsRetrieve.class));
//            }
//        });

        jobList = findViewById(R.id.j_button1);


        jobList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JobProvider_home.this, ProvidersideAllApplicants.class));
            }
        });

        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home1:
                        Intent intent = new Intent(JobProvider_home.this, JobProvider_home.class);
                        startActivity(intent);
                        // do something here
                        return true;
                    case R.id.navigation_notification:
                        // do something here
                        return true;
                    case R.id.navigation_profile:
                        Intent intents = new Intent(JobProvider_home.this, Job_Provider_Profile.class);
                        startActivity(intents);

                        // do something here
                        return true;
                    default: return true;
                }
            }
        });

    }
}