package com.pfe.pfeoussama.controllers;

import com.pfe.pfeoussama.models.Blog;
import com.pfe.pfeoussama.models.Metting;
import com.pfe.pfeoussama.payload.request.BlogRequest;
import com.pfe.pfeoussama.payload.request.MeetingRequest;
import com.pfe.pfeoussama.payload.response.MessageResponse;
import com.pfe.pfeoussama.repository.BlogRespository;
import com.pfe.pfeoussama.repository.MeetingRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Metting")
public class MettingEnLigne {

    @Autowired
    MeetingRespository meetingRespository;



    @PostMapping("/AddMeting")
    public ResponseEntity<?> AddBlog(@Valid @RequestBody MeetingRequest meetingRequest) {

        Metting metting = new Metting(meetingRequest.getName(),meetingRequest.getLienmeet(),meetingRequest.getIdFormateur(),meetingRequest.getDate());


        meetingRespository.save(metting);



        return ResponseEntity.ok(new MessageResponse("Meeting Added"));
    }






}
