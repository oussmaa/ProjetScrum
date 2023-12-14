package com.pfe.pfeoussama.payload.request;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class SalonDisscussionRequest {


    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String Nom;
    private String Image;
    private Date date;
}
