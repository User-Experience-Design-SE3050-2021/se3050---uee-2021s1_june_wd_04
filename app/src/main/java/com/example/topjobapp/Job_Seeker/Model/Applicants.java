package com.example.topjobapp.Job_Seeker.Model;

public class Applicants {

    private String age, category, email, experience, name, place, position, qualification, skills, date, time, image, itemKey;

    public Applicants(){

    }

    public Applicants(String age, String category, String email, String experience, String name, String place, String position, String qualification, String skills, String date, String time, String image, String itemKey) {
        this.age = age;
        this.category = category;
        this.email = email;
        this.experience = experience;
        this.name = name;
        this.place = place;
        this.position = position;
        this.qualification = qualification;
        this.skills = skills;
        this.date = date;
        this.time = time;
        this.image = image;
        this.itemKey = itemKey;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }
}
