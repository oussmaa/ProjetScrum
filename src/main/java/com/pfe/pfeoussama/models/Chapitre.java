package com.pfe.pfeoussama.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "chapitre")

public class Chapitre {
    @Id
    private String id;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Chapitre() {
    }

    private Date date;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



    private String Name;

    public String getIdFormation() {
        return IdFormation;
    }

    public void setIdFormation(String idFormation) {
        IdFormation = idFormation;
    }

    private String IdFormation;
    public Chapitre(String name, String idFormation, Date date) {
        Name = name;
        this.IdFormation = idFormation;
        this.date=date;
    }


}
