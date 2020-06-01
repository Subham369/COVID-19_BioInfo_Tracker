package com.example.covid_19bioinfotracker;

public class User {
   private String username;
    private String dob;

    public User() {
    }

    public User(String username, String dob, String phone_number, String email, String address) {
        this.username = username;
        this.dob = dob;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    private String phone_number;
    private String email;
    private String address;
}
