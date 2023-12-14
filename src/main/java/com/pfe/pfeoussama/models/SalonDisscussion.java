package com.pfe.pfeoussama.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "SalonDiscussion")
public class SalonDisscussion {


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
    @Id
    private String id;

    private String Nom;
    private String Image;
    private Date date;

    public SalonDisscussion(String nom, String image, Date date) {
        Nom = nom;
        Image = image;
        this.date = date;
    }

    public SalonDisscussion() {
    }
}
