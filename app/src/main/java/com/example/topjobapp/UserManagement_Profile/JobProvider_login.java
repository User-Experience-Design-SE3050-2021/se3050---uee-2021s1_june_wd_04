package com.example.topjobapp.UserManagement_Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.topjobapp.JobProvider_home;
import com.example.topjobapp.Model.JobProvider;
import com.example.topjobapp.Model.JobSeeker;
import com.example.topjobapp.Prevalent.Prevalent;
import com.example.topjobapp.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JobProvider_login extends AppCompatActivity {

    private Button u_button9, forgot;
    private TextInputLayout name, password;

    private String parentDbName = "JobProvider";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_provider_login);


        name = findViewById(R.id.u_unames);
        password = findViewById(R.id.u_upasss);
        u_button9 = findViewById(R.id.u_button9);
        forgot = findViewById(R.id.button45);

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobProvider_login.this,Seeker_Forget_Password.class);
                startActivity(intent);
            }
        });

        u_button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();

            }
        });


    }

    private void Login() {

        String t_names = name.getEditText().getText().toString().trim();
        String t_passwords = password.getEditText().getText().toString().trim();

        if(TextUtils.isEmpty(t_names) || TextUtils.isEmpty(t_passwords)){
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        }
        else{

            LoginValidation(t_names, t_passwords);
        }
    }

    private void LoginValidation(String t_names, String t_passwords) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                if(datasnapshot.child(parentDbName).child(t_names).exists())
                {
                    JobProvider userData = datasnapshot.child(parentDbName).child(t_names).getValue(JobProvider.class);

                    if(userData.getUsername().equals(t_names))
                    {
                        if(userData.getPassword().equals(t_passwords))
                        {
                            Toast.makeText(JobProvider_login.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(JobProvider_login.this, JobProvider_home.class);
                            startActivity(intent);

                            Prevalent.currentOnlineProvider = userData;
                        }
                        else{
                            Toast.makeText(JobProvider_login.this, "email or password incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else {
                    Toast.makeText(JobProvider_login.this, "Account with this "+t_names+ " email do not exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}