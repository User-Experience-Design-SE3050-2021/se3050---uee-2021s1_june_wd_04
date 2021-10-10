package com.example.topjobapp.UserManagement_Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.topjobapp.Job_Seeker.Add_Applicant;
import com.example.topjobapp.Job_Seeker.Job_Seeker_Home;
import com.example.topjobapp.R;


public class JobSeeker_login extends AppCompatActivity {

    private Button seekerForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker_login);

        seekerForm = findViewById(R.id.u_button9);

        seekerForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JobSeeker_login.this, Job_Seeker_Home.class));
            }
        });


    }
}