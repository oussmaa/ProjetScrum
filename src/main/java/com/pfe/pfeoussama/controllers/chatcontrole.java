package com.pfe.pfeoussama.controllers;

import com.pfe.pfeoussama.models.Message;
import com.pfe.pfeoussama.models.User;
import com.pfe.pfeoussama.payload.response.MessageResponse;
import com.pfe.pfeoussama.repository.FixDateRespository;
import com.pfe.pfeoussama.repository.MeetingRespository;
import com.pfe.pfeoussama.repository.MessageRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*", maxAge = 3600)
@RestController
@Controller
public class chatcontrole {

    @Autowired
    MessageRespository messageRespository;

    @MessageMapping("/sendmsg/{id}")
    @SendTo("/chat/messages")
    public Message chat(Message message, @DestinationVariable String id) throws Exception {

        return new Message(message.getText(), message.getUsername(), message.getAvatar(),message.getRoom(),message.getIdsend(),message.getDate());
    }

    @MessageMapping("/sendmsg2/{id}")
    @SendTo("/chat/support")
    public Message chatsupport(Message message, @DestinationVariable String id) throws Exception {

        return new Message(message.getText(), message.getUsername(), message.getAvatar(),message.getRoom(),message.getIdsend(),message.getDate());
    }
}
