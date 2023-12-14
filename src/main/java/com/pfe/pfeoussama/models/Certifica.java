package com.pfe.pfeoussama.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection = "Certifica")
public class Certifica {
    @Id
    private String id;
    private String NameUser;
    private String IdUser;
    private String Type;

    private String Nameformation;
    private String Date;
    public Certifica(String idUser, String type,String nameUser, String nameformation, String date) {
        IdUser = idUser;
        Type = type;
        Nameformation = nameformation;
        Date = date;
        NameUser=nameUser;
    }

    public Certifica() {
    }

    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String nameUser) {
        NameUser = nameUser;
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
