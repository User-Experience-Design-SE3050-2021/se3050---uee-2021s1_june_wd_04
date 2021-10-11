package com.example.topjobapp.UserManagement_Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.topjobapp.R;

public class Reset_Password extends AppCompatActivity {

    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset__password);

        reset = findViewById(R.id.u_reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Reset_Password.this, "You Successfully Reset Password", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Reset_Password.this, welcome_page.class);
                startActivity(intent);
            }
        });
    }
}