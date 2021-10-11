package com.example.topjobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.topjobapp.Job_Seeker.ApplicantsRetrieve;
import com.example.topjobapp.UserManagement_Profile.JobProvider_login;

public class JobProvider_home extends AppCompatActivity {

    private Button jobVacancy;
    private Button jobList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_provider_home);



        jobVacancy = findViewById(R.id.j_button2);


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
    }
}