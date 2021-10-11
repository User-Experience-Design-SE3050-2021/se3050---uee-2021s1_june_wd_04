package com.example.topjobapp.UserManagement_Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topjobapp.JobProvider_home;
import com.example.topjobapp.Job_Seeker.Job_Seeker_Home;
import com.example.topjobapp.Prevalent.Prevalent;
import com.example.topjobapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Job_Seeker_Profile extends AppCompatActivity {

    private TextView name, email, dob, gender;
    private BottomNavigationView bottomnav;
    private Button logout, dlt;
    private ImageButton edit, pass, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job__seeker__profile);

        name = findViewById(R.id.u_namet);
        email = findViewById(R.id.u_emailt);
        dob = findViewById(R.id.u_dobt);
        gender = findViewById(R.id.u_gendert);

        edit = findViewById(R.id.u_imageButton3);
        pass = findViewById(R.id.u_imageButton9);
        back = findViewById(R.id.u_backh);

        dlt = findViewById(R.id.u_button11);

        bottomnav = findViewById(R.id.u_navd);
        logout = findViewById(R.id.u_logoutq);

        name.setText(Prevalent.currentOnlineUser.getUsername());
        email.setText(Prevalent.currentOnlineUser.getEmail());
        dob.setText(Prevalent.currentOnlineUser.getDob());
        gender.setText(Prevalent.currentOnlineUser.getGender());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Job_Seeker_Profile.this, Job_Seeker_Home.class);
                startActivity(intent);
            }
        });

        dlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Job_Seeker_Profile.this, "Your account successfully deleted", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Job_Seeker_Profile.this, welcome_page.class);
                startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Job_Seeker_Profile.this, Edit_Job_Seeker.class);
                startActivity(intent);
            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Job_Seeker_Profile.this, Change_Password.class);
                startActivity(intent);
            }
        });

        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home1:
                        Intent intent = new Intent(Job_Seeker_Profile.this, Job_Seeker_Home.class);
                        startActivity(intent);
                        // do something here
                        return true;
                    case R.id.navigation_notification:
                        // do something here
                        return true;
                    case R.id.navigation_profile:
                        Intent intents = new Intent(Job_Seeker_Profile.this, Job_Seeker_Profile.class);
                        startActivity(intents);

                        // do something here
                        return true;
                    default: return true;
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Job_Seeker_Profile.this, welcome_page.class);
                startActivity(intent);
            }
        });

    }
}