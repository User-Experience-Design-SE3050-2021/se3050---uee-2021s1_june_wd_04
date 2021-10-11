package com.example.topjobapp.UserManagement_Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.topjobapp.Job_Seeker.Job_Seeker_Home;
import com.example.topjobapp.Model.JobSeeker;
import com.example.topjobapp.Prevalent.Prevalent;

import com.example.topjobapp.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class JobSeeker_login extends AppCompatActivity {


    private TextInputLayout name, pass;
    private Button login, forget;

    private String parentDbName = "JobSeeker";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker_login);

        name = findViewById(R.id.u_uname);
        pass = findViewById(R.id.u_upass);

        forget = findViewById(R.id.u_fo);

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobSeeker_login.this,Seeker_Forget_Password.class);
                startActivity(intent);

            }
        });

        login = findViewById(R.id.u_button9);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });

    }

    private void LoginUser() {

        String t_name = name.getEditText().getText().toString().trim();
        String t_password = pass.getEditText().getText().toString().trim();

        if(TextUtils.isEmpty(t_name) || TextUtils.isEmpty(t_password)){
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        }
        else{

            LoginValidation(t_name, t_password);


        }

    }

    private void LoginValidation(String t_name, String t_password) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();


        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                if(datasnapshot.child(parentDbName).child(t_name).exists())
                {
                    JobSeeker userData = datasnapshot.child(parentDbName).child(t_name).getValue(JobSeeker.class);

                    if(userData.getUsername().equals(t_name))
                    {
                        if(userData.getPassword().equals(t_password))
                        {
                            Toast.makeText(JobSeeker_login.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(JobSeeker_login.this, Job_Seeker_Home.class);
                            startActivity(intent);

                            Prevalent.currentOnlineUser = userData;
                        }
                        else{
                            Toast.makeText(JobSeeker_login.this, "email or password incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else {
                    Toast.makeText(JobSeeker_login.this, "Account with this "+t_name+ " email do not exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}