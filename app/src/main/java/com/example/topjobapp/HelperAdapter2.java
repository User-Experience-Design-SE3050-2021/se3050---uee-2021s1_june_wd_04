package com.example.topjobapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HelperAdapter2 extends RecyclerView.Adapter{


    List<AddJobs> addjobs;

    public HelperAdapter2(List<AddJobs> addjobs) {
        this.addjobs= addjobs;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {



        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.all_vacancy2_layout,parent,false);
        HelperAdapter2.ViewHolderClass viewHolderClass = new HelperAdapter2.ViewHolderClass(view);

        return  viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {

        HelperAdapter2.ViewHolderClass viewHolderClass=(HelperAdapter2.ViewHolderClass)holder;
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

            category = itemView.findViewById(R.id.j_category1);
            position = itemView.findViewById(R.id.j_position1);
            closedate = itemView.findViewById(R.id.j_closedate1);

        }
    }
}

