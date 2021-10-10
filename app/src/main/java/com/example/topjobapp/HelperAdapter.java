package com.example.topjobapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter{

    List<AddJobs> addjobs;

    public HelperAdapter(List<AddJobs> addjobs) {
        this.addjobs = addjobs;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {



        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.all_vacancy_layout,parent,false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);

        return  viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {

        ViewHolderClass viewHolderClass=(ViewHolderClass)holder;
        AddJobs addjobsList = addjobs.get(position);

        viewHolderClass.category.setText(addjobsList.getCategory());
        viewHolderClass.position.setText(addjobsList.getPosition());
        viewHolderClass.closedate.setText(addjobsList.getClosedate());



    }

    @Override
    public int getItemCount() {

        return addjobs.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {

        TextView category, position, closedate;

        public ViewHolderClass(@NonNull @NotNull View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.j_category);
            position = itemView.findViewById(R.id.j_position);
            closedate = itemView.findViewById(R.id.j_closedate);

        }
    }
}




