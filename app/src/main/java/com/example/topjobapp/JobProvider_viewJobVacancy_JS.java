package com.example.topjobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class JobProvider_viewJobVacancy_JS extends AppCompatActivity {

    private Button allvaca;
    private Button busvac;
    private Button itvac;

    private ImageButton back_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_provider_view_job_vacancy_js);


        allvaca = findViewById(R.id.j_all_vacancies);


        allvaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JobProvider_viewJobVacancy_JS.this, View_jobList2.class));
            }
        });

        busvac = findViewById(R.id.j_button3_business);


        busvac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JobProvider_viewJobVacancy_JS.this, Business_vacancies.class));
            }
        });

        itvac = findViewById(R.id.j_button5_it);


        itvac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JobProvider_viewJobVacancy_JS.this, IT_vacancies.class));
            }
        });




        back_btn2 = findViewById(R.id.j_back_button_js);


        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JobProvider_viewJobVacancy_JS.this, JobProvider_home.class));
            }
        });
    }
}