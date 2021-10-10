package com.example.topjobapp.Model;

public class JobSeeker {

    private String username, email, dob, gender, password;

    private JobSeeker(){

    }

    public JobSeeker(String username, String email, String dob, String gender, String password) {
        this.username = username;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
