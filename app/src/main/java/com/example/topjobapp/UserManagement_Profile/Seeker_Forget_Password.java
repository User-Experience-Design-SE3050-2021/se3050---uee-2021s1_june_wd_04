package com.example.topjobapp.UserManagement_Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.topjobapp.Job_Seeker.Job_Seeker_Home;
import com.example.topjobapp.R;

public class Seeker_Forget_Password extends AppCompatActivity {

    private ImageButton arrow;
    private Button forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker__forget__password);

        arrow = findViewById(R.id.u_fbtn);
        forgot = findViewById(R.id.u_fgt);

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Seeker_Forget_Password.this, "continue", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Seeker_Forget_Password.this, Reset_Password.class);
                startActivity(intent);
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Seeker_Forget_Password.this, JobSeeker_login.class);
                startActivity(intent);
            }
        });
    }
}