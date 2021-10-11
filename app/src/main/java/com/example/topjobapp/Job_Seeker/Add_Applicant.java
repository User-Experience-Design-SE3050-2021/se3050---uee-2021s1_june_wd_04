package com.example.topjobapp.Job_Seeker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.topjobapp.R;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;

import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

public class Add_Applicant extends AppCompatActivity {

    private Button btn_RESET;
    private Button btn_SAVE;
    private EditText add_Name, add_Age, add_Place,  add_Position, add_Skills, add_Qualification , add_Experience, add_Email ;
    private ImageView add_Image;
    private ImageButton btn_back;
    private static final int GalleryPick = 1;
    private Uri ImageUri;
    private StorageReference ItemImagesRef;
    private DatabaseReference ItemsRef;
    private ProgressDialog loadingBar;
    Spinner spinner;

    private String name, age, place, email, category, position, skills, qualification, experience, saveCurrentDate, saveCurrentTime, itemKey, downloadImageUrl;;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_applicant);

        //get reference from the childrens Pots Images and Pots of the database
        ItemImagesRef = FirebaseStorage.getInstance().getReference().child("ApplicantsImages");
        ItemsRef = FirebaseDatabase.getInstance().getReference().child("Applicants");


        //Declare Variables to identify the widgets of the XML file
        btn_RESET = (Button) findViewById(R.id.btnreset);
        btn_SAVE = (Button) findViewById(R.id.btnsave);
        btn_back = (ImageButton) findViewById(R.id.backbtn1);
        add_Image = (ImageView) findViewById(R.id.applicantImageview);
        add_Name = (EditText) findViewById(R.id.js_name);
        add_Age = (EditText) findViewById(R.id.js_age);
        add_Place = (EditText) findViewById(R.id.js_place);
        //add_Category = (EditText) findViewById(R.id.js_category);
        add_Position = (EditText) findViewById(R.id.js_position);
        add_Skills = (EditText) findViewById(R.id.js_skills);
        add_Qualification = (EditText) findViewById(R.id.js_qualifications);
        add_Experience = (EditText) findViewById(R.id.js_experience);
        add_Email = (EditText) findViewById(R.id.js_email);
        loadingBar = new ProgressDialog(this);

        spinner = findViewById(R.id.spinner_1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        add_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
            }
        });

        btn_SAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateApplicantData();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add_Applicant.this, Job_Seeker_Home.class);
                startActivity(intent);
            }
        });

    }

    //upload an image from the Gallery to the system
    private void OpenGallery() {
        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, GalleryPick );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GalleryPick && resultCode == RESULT_OK && data!= null){
            ImageUri = data.getData();
            add_Image.setImageURI(ImageUri);
        }
    }

    //Validate all the data
    private void ValidateApplicantData() {
        name = add_Name.getText().toString();
        age = add_Age.getText().toString();
        place = add_Place.getText().toString();
        email = add_Email.getText().toString();
        category = spinner.getSelectedItem().toString();
        position = add_Position.getText().toString();
        skills = add_Skills.getText().toString();
        qualification = add_Qualification.getText().toString();
        experience = add_Experience.getText().toString();


        if(ImageUri == null){
            Toast.makeText(this, "Item image is mandatory..",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(name)){
            Toast.makeText(this,"Name is mandatory..",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(age)){
            Toast.makeText(this,"Age is mandatory..",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(place)){
            Toast.makeText(this,"Place is mandatory..",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"Place is mandatory..",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(category)){
            Toast.makeText(this,"Category is mandatory..",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(position)){
            Toast.makeText(this,"Position is mandatory..",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(skills)){
            Toast.makeText(this,"Skills is mandatory..",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(qualification)){
            Toast.makeText(this,"Qualification is mandatory..",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(experience)){
            Toast.makeText(this,"Experience is mandatory..",Toast.LENGTH_SHORT).show();
        }

        else{
            StoreItemInformation();
        }


    }

    private void StoreItemInformation() {
        // Dialog box, while adding the item to the system
        loadingBar.setTitle("Add new Applicant");
        loadingBar.setMessage("Please wait, while we are adding the new applicant.");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();
        Calendar calendar = Calendar.getInstance();

        //get the current date
        @SuppressLint("SimpleDateFormat") SimpleDateFormat currentDate = new SimpleDateFormat("MM DD yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        //get the current time
        @SuppressLint("SimpleDateFormat") SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        itemKey = saveCurrentDate + saveCurrentTime;

        StorageReference filePath = ItemImagesRef.child(ImageUri.getLastPathSegment() + itemKey + "jpg");

        final UploadTask uploadTask = filePath.putFile(ImageUri);

        uploadTask.addOnFailureListener(new OnFailureListener(){
            @Override
            public void onFailure (@NonNull Exception e){
                String message = e.toString();
                Toast.makeText(Add_Applicant.this,"Error: " + message, Toast.LENGTH_SHORT).show();
                loadingBar.dismiss();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>(){
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(Add_Applicant.this,"Applicant image uploaded successfully...", Toast.LENGTH_SHORT).show();

                Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if(!task.isSuccessful()){
                            throw task.getException();


                        }

                        downloadImageUrl = filePath.getDownloadUrl().toString();
                        return filePath.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if(task.isSuccessful()){

                            downloadImageUrl = task.getResult().toString();
                            Toast.makeText(Add_Applicant.this, "got the applicant image url successfully..", Toast.LENGTH_SHORT).show();

                            SaveItemInfoToDatabase();

                        }
                    }
                });
            }

        });

    }

    private void SaveItemInfoToDatabase() {
        //save all the data to the database
        HashMap<String, Object> itemMap = new HashMap<>();
        itemMap.put("itemKey", itemKey);
        itemMap.put("name", name);
        itemMap.put("age", age);
        itemMap.put("place", place);
        itemMap.put("email", email);
        itemMap.put("category", category);
        itemMap.put("position", position);
        itemMap.put("skills", skills);
        itemMap.put("qualification", qualification);
        itemMap.put("experience", experience);
        itemMap.put("date", saveCurrentDate);
        itemMap.put("time", saveCurrentTime);
        itemMap.put("image", downloadImageUrl);
        //itemMap.put("category", category);

        ItemsRef.child(itemKey).updateChildren(itemMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(Add_Applicant.this, RetrieveAllApplicants.class);
                            startActivity(intent);

                            loadingBar.dismiss();
                            Toast.makeText(Add_Applicant.this, "Applicant is added successfully..", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            loadingBar.dismiss();
                            String message = task.getException().toString();
                            Toast.makeText(Add_Applicant.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}