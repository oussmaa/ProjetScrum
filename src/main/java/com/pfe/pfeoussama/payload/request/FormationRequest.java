package com.pfe.pfeoussama.payload.request;

import com.pfe.pfeoussama.models.Chapitre;
import com.pfe.pfeoussama.models.Leceon;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FormationRequest {
    @Id
    private String id;
private Date date;

    private String Name;

    private String Image;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    private String Type;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
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
