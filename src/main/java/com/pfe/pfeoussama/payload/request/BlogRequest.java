package com.pfe.pfeoussama.payload.request;

import java.util.Date;

public class BlogRequest {
    private String IdUser;

    private String Image;
    private java.util.Date Date;



    private String Tech;
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getTech() {
        return Tech;
    }

    public void setTech(String tech) {
        Tech = tech;
    }

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String idUser) {
        IdUser = idUser;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getDegration() {
        return Degration;
    }

    public void setDegration(int degration) {
        Degration = degration;
    }

    private String Description;

    private int Degration;
}
