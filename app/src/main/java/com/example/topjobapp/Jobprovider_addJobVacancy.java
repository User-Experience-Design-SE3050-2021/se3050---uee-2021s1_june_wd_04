package com.example.topjobapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Jobprovider_addJobVacancy extends AppCompatActivity {

    private Button button1;
    private EditText compnayname, category, city, position, salary, email, closedate, qualification;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobprovider_add_job_vacancy);

        button1 = (Button) findViewById(R.id.j_save);

        compnayname = (EditText) findViewById(R.id.j_companyname);
        category = (EditText) findViewById(R.id.j_category);
        city = (EditText) findViewById(R.id.j_city);
        position = (EditText) findViewById(R.id.j_position);
        salary = (EditText) findViewById(R.id.j_salary);
        email = (EditText) findViewById(R.id.j_email);
        closedate = (EditText) findViewById(R.id.j_closedate);
        qualification = (EditText) findViewById(R.id.j_qualification);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Createjob();
            }
        });




    }

    private void Createjob() {

        String c_companyname = compnayname.getText().toString();
        String c_category = category.getText().toString();
        String c_city = city.getText().toString();
        String c_position = position.getText().toString();
        String c_salary = salary.getText().toString();
        String c_email = email.getText().toString();
        String c_closedate = closedate.getText().toString();
        String c_qualification = qualification.getText().toString();


        if (TextUtils.isEmpty(c_companyname) || TextUtils.isEmpty(c_category) || TextUtils.isEmpty(c_city) || TextUtils.isEmpty(c_position) || TextUtils.isEmpty(c_salary) || TextUtils.isEmpty(c_email) || TextUtils.isEmpty(c_closedate) || TextUtils.isEmpty(c_qualification)) {
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        } else
            ValidateJobVacancy(c_companyname, c_category, c_city, c_position, c_salary, c_email, c_closedate, c_qualification);

    }

    private void ValidateJobVacancy(String c_companyname, String c_category, String c_city, String c_position, String c_salary, String c_email, String c_closedate, String c_qualification) {


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot dataSnapshot) {

                if (!(dataSnapshot.child("AddJobs").child(c_companyname).exists())) {

                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("compnayname", c_companyname);
                    userdataMap.put("category", c_category);
                    userdataMap.put("city", c_city);
                    userdataMap.put("position", c_position);
                    userdataMap.put("salary", c_salary);
                    userdataMap.put("email", c_email);
                    userdataMap.put("closedate", c_closedate);
                    userdataMap.put("qualification", c_qualification);

                    RootRef.child("AddJobs").child(c_companyname).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(Jobprovider_addJobVacancy.this, "Congratulations, your job vacancy is successfully added.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(Jobprovider_addJobVacancy.this, JobProvider_home.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(Jobprovider_addJobVacancy.this, "Failed to add job vacancy details", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                }

            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

            }
        });
    }
}





