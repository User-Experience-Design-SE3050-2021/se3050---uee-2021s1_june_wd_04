package com.example.topjobapp.UserManagement_Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.topjobapp.R;


public class welcome_page extends AppCompatActivity {

    private Button seeker, provider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        seeker = findViewById(R.id.u_btn5);
        provider = findViewById(R.id.u_button6);



        seeker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(welcome_page.this, SeekerSign_in_up.class));
            }
        });

        provider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(welcome_page.this, provider_sign_in_up.class));
            }
        });


    }
}