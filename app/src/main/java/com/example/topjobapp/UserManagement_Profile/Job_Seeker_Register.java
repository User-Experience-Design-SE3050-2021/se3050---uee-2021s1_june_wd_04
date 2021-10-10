package com.example.topjobapp.UserManagement_Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.topjobapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Job_Seeker_Register extends AppCompatActivity {

    private TextInputLayout username, email, dob, gender, password;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job__seeker__register);

        username = findViewById(R.id.u_usernane);
        email = findViewById(R.id.u_email);
        dob = findViewById(R.id.u_dob);
        gender = findViewById(R.id.u_gender);
        password = findViewById(R.id.u_password);
        register = findViewById(R.id.u_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register1();
            }
        });
    }

    private void register1() {

        String t_name = username.getEditText().getText().toString().trim();
        String t_email = email.getEditText().getText().toString().trim();
        String t_dob = dob.getEditText().getText().toString().trim();
        String t_gender = gender.getEditText().getText().toString().trim();
        String t_password = password.getEditText().getText().toString().trim();

        if(TextUtils.isEmpty(t_name) || TextUtils.isEmpty(t_email) || TextUtils.isEmpty(t_dob) || TextUtils.isEmpty(t_gender) || TextUtils.isEmpty(t_password)){
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        }
        else{

            ValidateRegister(t_name, t_email, t_gender, t_password, t_dob);
        }
    }

    private void ValidateRegister(final String t_name, String t_email, String t_gender, String t_password, String t_dob) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("JobSeeker").child(t_name).exists()))
                {
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("username", t_name);
                    userdataMap.put("email", t_email);
                    userdataMap.put("gender", t_gender);
                    userdataMap.put("password", t_password);
                    userdataMap.put("dob", t_dob);

                    RootRef.child("JobSeeker").child(t_name).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(Job_Seeker_Register.this, "Congratulations, your account has been created.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(Job_Seeker_Register.this, JobSeeker_login.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(Job_Seeker_Register.this, "register failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }
                else{
                    Toast.makeText(Job_Seeker_Register.this, "This " + t_name + " already exists.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Job_Seeker_Register.this, Job_Seeker_Register.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}