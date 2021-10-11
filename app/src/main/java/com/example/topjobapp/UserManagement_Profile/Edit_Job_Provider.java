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

public class Edit_Job_Provider extends AppCompatActivity {

    private TextInputEditText uname, email, cname, cadd, phn;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__job__provider);

        uname = findViewById(R.id.u_enamee);
        email = findViewById(R.id.eemaile);
        cname = findViewById(R.id.u_cnamee);
        cadd = findViewById(R.id.u_caddress);
        phn = findViewById(R.id.u_phnno);

        edit = findViewById(R.id.u_editpr);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Edit_Job_Provider.this, "Your profile Successfully updated", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Edit_Job_Provider.this, Job_Provider_Profile.class);
                startActivity(intent);
            }
        });

        uname.setText(Prevalent.currentOnlineProvider.getUsername());
        email.setText(Prevalent.currentOnlineProvider.getEmail());
        cname.setText(Prevalent.currentOnlineProvider.getCname());
        cadd.setText(Prevalent.currentOnlineProvider.getAddress());
        phn.setText(Prevalent.currentOnlineProvider.getPhone());
    }
}