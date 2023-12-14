package com.pfe.pfeoussama.payload.request;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Certificarequest {
    @Id
    private String id;
    private String NameUser;
    private String IdUser;
    private String Type;

    private String Nameformation;
    private String Date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String nameUser) {
        NameUser = nameUser;
    }

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String idUser) {
        IdUser = idUser;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getNameformation() {
        return Nameformation;
    }

    public void setNameformation(String nameformation) {
        Nameformation = nameformation;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
