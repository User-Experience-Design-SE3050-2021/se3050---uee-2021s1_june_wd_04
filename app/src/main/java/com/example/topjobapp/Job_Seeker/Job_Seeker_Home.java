package com.example.topjobapp.Job_Seeker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.topjobapp.R;
import com.example.topjobapp.UserManagement_Profile.JobSeeker_login;

public class Job_Seeker_Home extends AppCompatActivity {

    private ImageView jobVacancy;
    private ImageView addApplicant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker_home);

        jobVacancy = findViewById(R.id.job_vacancies_image);
        addApplicant = findViewById(R.id.add_applicant_image);

        jobVacancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Job_Seeker_Home.this, ApplicantsRetrieve.class));
            }
        });

        addApplicant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Job_Seeker_Home.this, Add_Applicant.class));
            }
        });
    }
}