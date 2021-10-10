package com.example.topjobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class IT_vacancies extends AppCompatActivity {


    private ImageButton back_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_vacancies);


        back_btn2 = findViewById(R.id.j_back_button_itvacn);


        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IT_vacancies.this, JobProvider_viewJobVacancy_JS.class));
            }
        });
    }
}