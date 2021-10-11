package com.example.topjobapp.UserManagement_Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.topjobapp.Prevalent.Prevalent;
import com.example.topjobapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Edit_Job_Seeker extends AppCompatActivity {


    private TextInputEditText uname, email, gender, dob;
    private Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__job__seeker);


        email = findViewById(R.id.u_eemails);
        dob = findViewById(R.id.u_edobs);
        gender = findViewById(R.id.u_egenders);
        uname = findViewById(R.id.u_enameb);
        edit = findViewById(R.id.u_edit);

        uname.setText(Prevalent.currentOnlineUser.getUsername());
        email.setText(Prevalent.currentOnlineUser.getEmail());
        dob.setText(Prevalent.currentOnlineUser.getDob());
        gender.setText(Prevalent.currentOnlineUser.getGender());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Edit_Job_Seeker.this, "Your profile Successfully updated", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Edit_Job_Seeker.this, Job_Seeker_Profile.class);
                startActivity(intent);
            }
        });
    }
}