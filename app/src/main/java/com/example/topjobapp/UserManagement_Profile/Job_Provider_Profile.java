package com.example.topjobapp.UserManagement_Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topjobapp.JobProvider_home;
import com.example.topjobapp.Prevalent.Prevalent;
import com.example.topjobapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Job_Provider_Profile extends AppCompatActivity {

    private TextView name, email, cname, caddress, phn;
    private ImageButton edit, pass;
    private Button logout, dlt;
    private BottomNavigationView bottomnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job__provider__profile);

        name = findViewById(R.id.u_unamef);
        email = findViewById(R.id.uemailf);
        cname = findViewById(R.id.ucnamef);
        caddress = findViewById(R.id.ucaddf);
        phn = findViewById(R.id.uphnf);

        edit = findViewById(R.id.u_jebtn);
        pass = findViewById(R.id.u_jepd);
        logout = findViewById(R.id.u_logouty);

        bottomnav = findViewById(R.id.u_navdj);

        dlt = findViewById(R.id.u_dltq);

        dlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Job_Provider_Profile.this, "Your account successfully deleted", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Job_Provider_Profile.this, welcome_page.class);
                startActivity(intent);
            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Job_Provider_Profile.this, Provider_Password.class);
                startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Job_Provider_Profile.this, Edit_Job_Provider.class);
                startActivity(intent);
            }
        });

        name.setText(Prevalent.currentOnlineProvider.getUsername());
        email.setText(Prevalent.currentOnlineProvider.getEmail());
        cname.setText(Prevalent.currentOnlineProvider.getCname());
        caddress.setText(Prevalent.currentOnlineProvider.getAddress());
        phn.setText(Prevalent.currentOnlineProvider.getPhone());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Job_Provider_Profile.this, "Successfully Logout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Job_Provider_Profile.this, welcome_page.class);
                startActivity(intent);
            }
        });

        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home1:
                        Intent intent = new Intent(Job_Provider_Profile.this, JobProvider_home.class);
                        startActivity(intent);
                        // do something here
                        return true;
                    case R.id.navigation_notification:
                        // do something here
                        return true;
                    case R.id.navigation_profile:
                        Intent intents = new Intent(Job_Provider_Profile.this, Job_Provider_Profile.class);
                        startActivity(intents);

                        // do something here
                        return true;
                    default: return true;
                }
            }
        });
    }
}