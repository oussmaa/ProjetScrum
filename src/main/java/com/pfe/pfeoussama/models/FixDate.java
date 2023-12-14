package com.pfe.pfeoussama.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "FixDate")
public class FixDate {

    @Id
    private String id;
    private String date;
    private String titre;
    private String nomf;
    private String lienmeet;
    private String type;
    private String idFormateur;
    private boolean   over;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public String getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(String idFormateur) {
        this.idFormateur = idFormateur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLienmeet() {
        return lienmeet;
    }

    public void setLienmeet(String lienmeet) {
        this.lienmeet = lienmeet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNomf() {
        return nomf;
    }

    public void setNomf(String nomf) {
        this.nomf = nomf;
    }
}
