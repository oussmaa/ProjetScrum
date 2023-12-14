package com.pfe.pfeoussama.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Metting {

    @Id
    private String id;
    private String name;
    private String lienmeet;
    private String idFormateur;
    private Date date;
    public Metting(String name, String lienmeet,String idFormateur,Date date) {
        this.name = name;
        this.lienmeet = lienmeet;
        this.idFormateur = idFormateur;
        this.date = date;
    }

    public String getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(String idFormateur) {
        this.idFormateur = idFormateur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLienmeet() {
        return lienmeet;
    }

    public void setLienmeet(String lienmeet) {
        this.lienmeet = lienmeet;
    }
}
