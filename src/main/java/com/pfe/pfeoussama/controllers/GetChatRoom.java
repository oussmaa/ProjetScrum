package com.pfe.pfeoussama.controllers;

import com.pfe.pfeoussama.models.Blog;
import com.pfe.pfeoussama.models.Message;
import com.pfe.pfeoussama.models.Notification;
import com.pfe.pfeoussama.payload.request.MeetingRequest;
import com.pfe.pfeoussama.payload.request.MessageRequest;
import com.pfe.pfeoussama.payload.request.NotificationRequest;
import com.pfe.pfeoussama.payload.response.MessageResponse;
import com.pfe.pfeoussama.repository.MessageRespository;
import com.pfe.pfeoussama.repository.NotificationRespository;
import com.pfe.pfeoussama.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/getmessage")
public class GetChatRoom {

    @Autowired
    MessageRespository messageRespository;

    @Autowired
    NotificationRespository notificationRespository;


    @GetMapping("/findbyroom/{room}")
    public List<Message> getbuiduser(@PathVariable("room") String room){
        List<Message> messages = this.messageRespository.findByRoom(room);
        return messages;
    }
    @PostMapping("/Addmessage")
    public ResponseEntity<?> addmesage(@Valid @RequestBody MessageRequest messageRequest) {


        Message message = new Message(messageRequest.getText(),messageRequest.getUsername(),messageRequest.getAvatar(),messageRequest.getRoom(),messageRequest.getIdsend(),messageRequest.getDate());

        messageRespository.save(message);



        return ResponseEntity.ok(new MessageResponse("Message ajouter"));
    }
    @PostMapping("/Addnotif")
    public ResponseEntity<?> addnotif(@Valid @RequestBody NotificationRequest notificationRequest) {


        Notification notif = new Notification(notificationRequest.getText(), notificationRequest.getSendid(),notificationRequest.getDate());

        notificationRespository.save(notif);



        return ResponseEntity.ok(new MessageResponse("Notification ajouter"));
    }
    @GetMapping("/getAllNotif")
    public List<Notification> getallnotif() {
        return notificationRespository.findAll();
    }




    @GetMapping("/findbyidsend/{idsend}")
    public List<Message> getMessage(@PathVariable("idsend") String idsend){
        List<Message> messages = this.messageRespository.findByIdsend(idsend);


        return messages;
    }
    @GetMapping("/findbyusername/{username}")
    public List<Message> finbyrooo(@PathVariable("username") String username){
        List<Message> messages = this.messageRespository.findByUsername(username);


        return messages;
    }
    @DeleteMapping("/deletemessage/{id}")
    public ResponseEntity<HttpStatus> deleteSalon(@PathVariable("id") String id) {
        try {
            messageRespository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
