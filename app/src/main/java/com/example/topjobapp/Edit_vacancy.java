package com.example.topjobapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Edit_vacancy extends AppCompatActivity {


    private ImageButton back_btn2;
    private Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_vacancy);



        edit = findViewById(R.id.j_button_editvcan);


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Edit_vacancy.this, "Your vacancy details are successfully edited.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Edit_vacancy.this, View_JobList.class));
            }
        });




        back_btn2 = findViewById(R.id.j_back_button_editvacan);


        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Edit_vacancy.this, View_JobList.class));
            }
        });


    }
}