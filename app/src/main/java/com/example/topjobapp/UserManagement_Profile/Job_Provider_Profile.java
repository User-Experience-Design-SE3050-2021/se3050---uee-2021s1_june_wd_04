package com.example.topjobapp.UserManagement_Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.topjobapp.Prevalent.Prevalent;
import com.example.topjobapp.R;

public class Job_Provider_Profile extends AppCompatActivity {

    private TextView name, email, cname, caddress, phn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job__provider__profile);

        name = findViewById(R.id.u_unamef);
        email = findViewById(R.id.uemailf);
        cname = findViewById(R.id.ucnamef);
        caddress = findViewById(R.id.ucaddf);
        phn = findViewById(R.id.uphnf);

        name.setText(Prevalent.currentOnlineProvider.getUsername());
        email.setText(Prevalent.currentOnlineProvider.getEmail());
        cname.setText(Prevalent.currentOnlineProvider.getCname());
        caddress.setText(Prevalent.currentOnlineProvider.getAddress());
        phn.setText(Prevalent.currentOnlineProvider.getPhone());
    }
}