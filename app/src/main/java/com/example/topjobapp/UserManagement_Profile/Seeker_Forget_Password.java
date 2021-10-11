package com.example.topjobapp.UserManagement_Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.topjobapp.Job_Seeker.Job_Seeker_Home;
import com.example.topjobapp.R;

public class Seeker_Forget_Password extends AppCompatActivity {

    private ImageButton arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker__forget__password);

        arrow = findViewById(R.id.u_fbtn);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Seeker_Forget_Password.this, JobSeeker_login.class);
                startActivity(intent);
            }
        });
    }
}