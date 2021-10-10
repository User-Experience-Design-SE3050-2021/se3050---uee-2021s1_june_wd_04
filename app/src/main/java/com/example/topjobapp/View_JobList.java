package com.example.topjobapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class View_JobList extends AppCompatActivity {

    private FloatingActionButton vcnform;
    private ImageButton editvac;
    private ImageButton deletevac;

    private ImageButton back_btn2;


    List<AddJobs> addjobs;
    RecyclerView recyclerView;
    HelperAdapter helperAdapter;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_job_list);


//        ------------------

        vcnform = findViewById(R.id.j_add_floating_btn);

        vcnform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(View_JobList.this, Jobprovider_addJobVacancy.class));
            }
        });


        editvac = findViewById(R.id.j_imageButton_edit_fake);

        editvac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(View_JobList.this, Edit_vacancy.class));
            }
        });


        deletevac = findViewById(R.id.j_imageButton_delete_fake);

        deletevac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(View_JobList.this, Delete_vacancy.class));
            }
        });


        back_btn2 = findViewById(R.id.j_back_button_all_job_vacancies);


        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(View_JobList.this, JobProvider_home.class));
            }
        });

//        --------- --------------- --------------- ---------



        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addjobs = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("AddJobs");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    AddJobs data = ds.getValue(AddJobs.class);
                    addjobs.add(data);
                }
                helperAdapter =  new HelperAdapter(addjobs);
                recyclerView.setAdapter(helperAdapter);
            }


            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }
}