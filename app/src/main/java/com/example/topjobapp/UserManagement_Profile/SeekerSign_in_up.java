package com.example.topjobapp.UserManagement_Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.topjobapp.R;

public class SeekerSign_in_up extends AppCompatActivity {

    private Button signin, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker_sign_in_up);

        signin = findViewById(R.id.u_logins);
        signup = findViewById(R.id.u_regs);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeekerSign_in_up.this, JobSeeker_login.class));

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeekerSign_in_up.this, Job_Seeker_Register.class));
            }
        });
    }
}