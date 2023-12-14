package com.pfe.pfeoussama.payload.request;

import com.pfe.pfeoussama.models.Leceon;

import java.util.Date;
import java.util.List;

public class ChapitreRequest {



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;
    private String Name;

    public String getIdFormation() {
        return IdFormation;
    }

    public void setIdFormation(String idFormation) {
        IdFormation = idFormation;
    }

    private String IdFormation;
}
