package com.example.covid_19bioinfotracker;

public class HelpAdderList {
    public HelpAdderList() {
    }



    public HelpAdderList(String textDescription, String textname, String textphone) {
        this.textDescription = textDescription;
        this.textname = textname;
        this.textphone = textphone;
    }
    private String textDescription;

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getTextname() {
        return textname;
    }

    public void setTextname(String textname) {
        this.textname = textname;
    }

    public String getTextphone() {
        return textphone;
    }

    public void setTextphone(String textphone) {
        this.textphone = textphone;
    }

    private String textname;
    private String textphone;
}
