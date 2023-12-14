package com.pfe.pfeoussama.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "Formation")
public class Fomation {
    @Id
    private String id;

    private   Date date;
    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    private String Name;
    private String Image;
    private String Type;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Fomation() {
    }



    public Fomation(String name, String type, String  image, Date date) {
        Name = name;
    this.date=date;
        this.Type=type;
        this.Image = image;
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
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }




}
