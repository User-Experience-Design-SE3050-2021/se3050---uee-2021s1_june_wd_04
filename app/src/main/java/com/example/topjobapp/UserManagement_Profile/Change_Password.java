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

public class Change_Password extends AppCompatActivity {

    private TextInputEditText password;
    private Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__password);

        password = findViewById(R.id.u_passe);
        edit = findViewById(R.id.u_button13);

        password.setText(Prevalent.currentOnlineUser.getPassword());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Change_Password.this, "Your password is changed", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Change_Password.this, Job_Seeker_Profile.class);
                startActivity(intent);
            }
        });
    }
}