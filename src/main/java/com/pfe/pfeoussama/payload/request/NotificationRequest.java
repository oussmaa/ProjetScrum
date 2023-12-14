package com.pfe.pfeoussama.payload.request;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class NotificationRequest {

    @Id
    private String id;
    private String text;
    private String sendid;
    private Date date;
    private int eta;

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSendid() {
        return sendid;
    }

    public void setSendid(String sendid) {
        this.sendid = sendid;
    }
}
