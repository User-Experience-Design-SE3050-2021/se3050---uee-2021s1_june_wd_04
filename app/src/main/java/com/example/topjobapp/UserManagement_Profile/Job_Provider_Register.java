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
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Job_Provider_Register extends AppCompatActivity {

    private TextInputLayout username, email, cname, cadd, phn, password;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job__provider__register);

        username =findViewById(R.id.u_usernamep);
        email =findViewById(R.id.u_emailp);
        cname =findViewById(R.id.u_cnamep);
        cadd =findViewById(R.id.u_add);
        phn =findViewById(R.id.u_phn);
        password = findViewById(R.id.u_passwordp);
        register = findViewById(R.id.u_registerp);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register2();
            }
        });
    }

    private void register2() {

        String t_uname = username.getEditText().getText().toString().trim();
        String t_email = email.getEditText().getText().toString().trim();
        String t_cname = cname.getEditText().getText().toString().trim();
        String t_cadd = cadd.getEditText().getText().toString().trim();
        String t_phn = phn.getEditText().getText().toString().trim();
        String t_password = password.getEditText().getText().toString().trim();

        if(TextUtils.isEmpty(t_uname) || TextUtils.isEmpty(t_email) || TextUtils.isEmpty(t_cname) || TextUtils.isEmpty(t_cadd) || TextUtils.isEmpty(t_phn) || TextUtils.isEmpty(t_password)){
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        }
        else{

            ValidateRegister(t_uname, t_email, t_cname, t_password, t_cadd, t_phn);
        }

    }

    private void ValidateRegister(final String t_uname, String t_email, String t_cname, String t_password, String t_cadd, String t_phn) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("JobProvider").child(t_uname).exists()))
                {
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("username", t_uname);
                    userdataMap.put("email", t_email);
                    userdataMap.put("cname", t_cname);
                    userdataMap.put("address", t_cadd);
                    userdataMap.put("phone", t_phn);
                    userdataMap.put("password", t_password);

                    RootRef.child("JobProvider").child(t_uname).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(Job_Provider_Register.this, "Congratulations, your account has been created.", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(Job_Provider_Register.this, JobProvider_login.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(Job_Provider_Register.this, "register failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }
                else{
                    Toast.makeText(Job_Provider_Register.this, "This " + t_uname + " already exists.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Job_Provider_Register.this, Job_Provider_Register.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}