package com.pfe.pfeoussama.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Blog")

public class Blog {
    @Id
    private String id;

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

    public Blog(String idUser, String image, String description, int degration, Date date, String tech,String name) {
        IdUser = idUser;
        Image = image;
        Description = description;
        Degration = degration;
        Date=date;
        Tech=tech;
        this.Name=name;
    }

    public Blog() {
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
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

