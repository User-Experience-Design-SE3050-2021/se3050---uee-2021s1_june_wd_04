package com.example.topjobapp.UserManagement_Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.topjobapp.JobProvider_home;
import com.example.topjobapp.R;

public class JobProvider_login extends AppCompatActivity {

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_provider_login);




        button1 = findViewById(R.id.u_button9);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JobProvider_login.this, JobProvider_home.class));
            }
        });
    }


}