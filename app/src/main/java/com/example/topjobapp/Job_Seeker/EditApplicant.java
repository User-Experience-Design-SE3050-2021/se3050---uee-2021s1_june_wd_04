package com.example.topjobapp.Job_Seeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.topjobapp.R;

import java.util.PrimitiveIterator;

public class EditApplicant extends AppCompatActivity {

    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_applicant);

        update = findViewById(R.id.btnsave);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditApplicant.this, RetrieveAllApplicants.class));
            }
        });
    }
}