package com.example.topjobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Delete_vacancy extends AppCompatActivity {


    private ImageButton back_btn2;
    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_vacancy);

        delete = findViewById(R.id.j_button_delete);


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Delete_vacancy.this, View_JobList.class));
            }
        });




        back_btn2 = findViewById(R.id.j_back_button_admn_dlt);


        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Delete_vacancy.this, View_JobList.class));
            }
        });
    }
}