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

public class Provider_Password extends AppCompatActivity {

    private TextInputEditText password;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider__password);

        password = findViewById(R.id.u_passee);
        save = findViewById(R.id.u_savee);

        password.setText(Prevalent.currentOnlineProvider.getPassword());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Provider_Password.this, "Your password is changed", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Provider_Password.this, Job_Provider_Profile.class);
                startActivity(intent);
            }
        });
    }
}