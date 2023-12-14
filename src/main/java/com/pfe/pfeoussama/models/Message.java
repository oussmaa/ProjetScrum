package com.pfe.pfeoussama.models;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "Message")

public class Message {

    @Id
    private String id;
    private String text;
    private String username;
    private String avatar;
    private String room;
    private String idsend;
    private Date date;

    public Message() {
    }

    public Message(String text , String username, String avatar, String room, String idsend,Date date) {
            this.text = text;
            this.username = username;
            this.avatar = avatar;
            this.room=room;
            this.idsend=idsend;
            this.date=date;
        }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdsend() {
        return idsend;
    }

    public void setIdsend(String idsend) {
        this.idsend = idsend;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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
    }