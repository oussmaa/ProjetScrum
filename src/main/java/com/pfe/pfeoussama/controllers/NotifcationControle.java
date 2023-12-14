package com.pfe.pfeoussama.controllers;

import com.pfe.pfeoussama.models.Message;
import com.pfe.pfeoussama.models.Notification;
import com.pfe.pfeoussama.repository.MessageRespository;
import com.pfe.pfeoussama.repository.NotificationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*", maxAge = 3600)
@RestController
public class NotifcationControle {







    @MessageMapping("/sendnotifcation")
    @SendTo("/chat/Notification")
    public Notification chat(Notification notification) throws Exception {

        return new Notification(notification.getText(), notification.getSendid(),notification.getDate());
    }
}
