package com.example.topjobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Favourte_lst_jobList extends AppCompatActivity {

    private ImageButton back_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourte_lst_job_list);


        back_btn2 = findViewById(R.id.j_back_button_fav_jobList);


        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Favourte_lst_jobList.this, View_jobList2.class));
            }
        });


    }
}