package com.example.topjobapp.Job_Seeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.topjobapp.Job_Seeker.Model.Applicants;
import com.example.topjobapp.Job_Seeker.ViewHolder.ApplicantViewHolder;
import com.example.topjobapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class ApplicantsRetrieve extends AppCompatActivity {

    private DatabaseReference ApplicantsRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicants_retrieve);

        ApplicantsRef = FirebaseDatabase.getInstance().getReference().child("Applicants");

        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Applicants> options =
                new FirebaseRecyclerOptions.Builder<Applicants>()
                .setQuery(ApplicantsRef, Applicants.class)
                .build();


        FirebaseRecyclerAdapter<Applicants, ApplicantViewHolder> adapter =
                new FirebaseRecyclerAdapter<Applicants, ApplicantViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull @NotNull ApplicantViewHolder applicantViewHolder, int i, @NonNull @NotNull Applicants applicants) {
                        applicantViewHolder.txtcategory.setText(applicants.getCategory());
                        applicantViewHolder.txtname.setText("Name: " + applicants.getName());
                        applicantViewHolder.txtplace.setText("Place: " + applicants.getPlace());
                        applicantViewHolder.txtposition.setText("Position: " + applicants.getPosition());
                        applicantViewHolder.txtemail.setText("Email: " + applicants.getEmail());
                        Picasso.get().load(applicants.getImage()).into(applicantViewHolder.imageView);

                    }

                    @NonNull
                    @NotNull
                    @Override
                    public ApplicantViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.applicants_layout, parent, false);
                        ApplicantViewHolder holder = new ApplicantViewHolder(view);
                        return holder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}