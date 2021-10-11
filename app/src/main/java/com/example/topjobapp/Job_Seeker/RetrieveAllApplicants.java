package com.example.topjobapp.Job_Seeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.topjobapp.R;

public class RetrieveAllApplicants extends AppCompatActivity {

    private ImageButton EditButton;
    private ImageButton view;
    private ImageButton add;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_all_applicants);

        EditButton = findViewById(R.id.imageButton2);
        view = findViewById(R.id.imageButton22);
        add = findViewById(R.id.floatingadd);
        back = findViewById(R.id.backbtn1);



        EditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RetrieveAllApplicants.this, EditApplicant.class));
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RetrieveAllApplicants.this, ApplicantInDetail.class));
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RetrieveAllApplicants.this, Add_Applicant.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RetrieveAllApplicants.this, Job_Seeker_Home.class));
            }
        });
    }
}