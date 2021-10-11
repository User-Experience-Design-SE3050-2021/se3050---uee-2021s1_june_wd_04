package com.example.topjobapp.Job_Seeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.topjobapp.R;

public class SavedApplicants extends AppCompatActivity {

    private ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_applicants);

        home = findViewById(R.id.imageButton6);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SavedApplicants.this, ProvidersideAllApplicants.class));
            }
        });
    }
}