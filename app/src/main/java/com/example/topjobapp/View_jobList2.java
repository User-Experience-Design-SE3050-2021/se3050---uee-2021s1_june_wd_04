package com.example.topjobapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class View_jobList2 extends AppCompatActivity {

    List<AddJobs> addjobs;
    RecyclerView recyclerView;
   HelperAdapter2 helperAdapter;
    DatabaseReference databaseReference;


    private ImageButton back_btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_job_list2);


        back_btn2 = findViewById(R.id.j_back_button_viewjoblist2);


        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(View_jobList2.this, JobProvider_viewJobVacancy_JS.class));
            }
        });



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
                    helperAdapter =  new HelperAdapter2(addjobs);
                    recyclerView.setAdapter(helperAdapter);
                }


                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });
        }


    }
