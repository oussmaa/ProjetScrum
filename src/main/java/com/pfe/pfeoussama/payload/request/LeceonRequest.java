package com.pfe.pfeoussama.payload.request;

import com.pfe.pfeoussama.models.Quiz;

import java.util.Date;

public class LeceonRequest {
    private String IdChapitre;

    public String getIdChapitre() {
        return IdChapitre;
    }

    public void setIdChapitre(String idChapitre) {
        IdChapitre = idChapitre;
    }
    private String Name;


    private String Cour;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private com.pfe.pfeoussama.models.Quiz Quiz;


    private String Video;



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCour() {
        return Cour;
    }

    public void setCour(String cour) {
        Cour = cour;
    }

    public Quiz getQuiz() {
        return Quiz;
    }

    public void setQuiz(Quiz quiz) {
        Quiz = quiz;
    }

    public String getVideo() {
        return Video;
    }

    public void setVideo(String video) {
        Video = video;
    }
}
