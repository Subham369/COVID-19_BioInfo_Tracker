package com.example.covid_19bioinfotracker.Fragment.Model;

public class Community_User {
    String id;
    String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    String fullName;
    String imageurl;
    String bio;

    public Community_User(String id, String userName, String fullName, String imageurl, String bio) {
        this.id = id;
        if (userName.trim().equals(""))
        {
            userName="No Name";
        }
        this.userName = userName;
        this.fullName = fullName;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    public Community_User() {
    }
}
