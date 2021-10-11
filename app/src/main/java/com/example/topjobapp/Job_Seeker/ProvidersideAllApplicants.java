package com.example.topjobapp.Job_Seeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;

import com.example.topjobapp.JobProvider_home;
import com.example.topjobapp.R;
import com.example.topjobapp.View_JobList;

public class ProvidersideAllApplicants extends AppCompatActivity {

    private ImageButton viewBtn;

    private ImageButton savebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_providerside_all_applicants);

        viewBtn = findViewById(R.id.imageButton22);
        savebtn = findViewById(R.id.imageButton12);

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProvidersideAllApplicants.this, ApplicantInDetail.class));
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProvidersideAllApplicants.this, SavedApplicants.class));
            }
        });
    }
}