package com.example.covid_19bioinfotracker;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String name,dob,phone,address;

    public User() {
    }


    public User(String address, String dob,String phone,String name) {

        if (name.trim().equals(""))
        {
            name="No Name";
        }
        this.address=address;
        this.dob=dob;
        this.phone=phone;
        this.name = name;

    }
}
