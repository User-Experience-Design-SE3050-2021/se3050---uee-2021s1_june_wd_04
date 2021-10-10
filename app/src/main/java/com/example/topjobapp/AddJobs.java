package com.example.topjobapp;

public class AddJobs {

    private String companyname;
    private String category;
    private String city;
    private String position;
    private String salary;
    private String email;
    private String closedate;
    private String qualification;

    public AddJobs(){}


    public AddJobs(String companyname, String category, String city, String position, String salary, String email, String closedate, String qualification) {
        this.companyname = companyname;
        this.category = category;
        this.city = city;
        this.position = position;
        this.salary = salary;
        this.email = email;
        this.closedate = closedate;
        this.qualification = qualification;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClosedate() {
        return closedate;
    }

    public void setClosedate(String closedate) {
        this.closedate = closedate;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
