package com.pfe.pfeoussama.payload.request;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class MessageRequest {



    @Id
    private String id;
    private String text;
    private String username;
    private String avatar;
    private String room;
    private String idsend;
    private Date date;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getIdsend() {
        return idsend;
    }

    public void setIdsend(String idsend) {
        this.idsend = idsend;
    }
}
