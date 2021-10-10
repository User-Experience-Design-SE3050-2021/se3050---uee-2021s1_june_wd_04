package com.example.topjobapp.Job_Seeker.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.topjobapp.Job_Seeker.Interface.ApplicantClickListner;
import com.example.topjobapp.R;

public class ApplicantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtcategory, txtname, txtplace, txtposition, txtemail;
        public ImageView imageView;
        public ApplicantClickListner listner;

    public ApplicantViewHolder(View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.applicants_images);
        txtcategory = (TextView) itemView.findViewById(R.id.categoryname);
        txtname = (TextView) itemView.findViewById(R.id.applicant_name);
        txtplace = (TextView) itemView.findViewById(R.id.applicant_place);
        txtposition = (TextView) itemView.findViewById(R.id.applicant_position);
        txtemail = (TextView) itemView.findViewById(R.id.applicant_email);

    }

    public void setApplicantClickListner(ApplicantClickListner listner){
            this.listner = listner;
    }

    @Override
    public void onClick(View v) {
            listner.onClick(v, getAdapterPosition(), false);
    }
}
