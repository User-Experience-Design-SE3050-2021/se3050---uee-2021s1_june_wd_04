package com.example.topjobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Business_vacancies extends AppCompatActivity {

    private ImageButton btn1;
    private ImageButton back_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_vacancies);




        btn1 = findViewById(R.id.j_bissmarketing_fake);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Business_vacancies.this, VAcancy_details.class));
            }
        });


        back_btn2 = findViewById(R.id.j_back_button_bsnesVacancies);


        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Business_vacancies.this,JobProvider_viewJobVacancy_JS.class));
            }
        });

    }
}