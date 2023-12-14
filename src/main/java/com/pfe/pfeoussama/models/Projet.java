package com.pfe.pfeoussama.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Projet")
public class Projet {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTypeprojet() {
        return typeprojet;
    }

    public void setTypeprojet(String typeprojet) {
        this.typeprojet = typeprojet;
    }
    public String getNameprojet() {
        return nameprojet;
    }

    public void setNameprojet(String nameprojet) {
        this.nameprojet = nameprojet;
    }
    @Id
    private String id;
    private String nameprojet;
    private Date date;
    private String typeprojet;



}
