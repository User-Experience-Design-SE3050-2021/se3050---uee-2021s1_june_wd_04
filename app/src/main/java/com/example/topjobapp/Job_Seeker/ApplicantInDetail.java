package com.example.topjobapp.Job_Seeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.topjobapp.R;

public class ApplicantInDetail extends AppCompatActivity {

    private ImageButton back;
    private Button contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_in_detail);

        back = findViewById(R.id.backbtn1);
        contact = findViewById(R.id.button9);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ApplicantInDetail.this, RetrieveAllApplicants.class));
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ApplicantInDetail.this, ProvidersideAllApplicants.class));
            }
        });
    }
}