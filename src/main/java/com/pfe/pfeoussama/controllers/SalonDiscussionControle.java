package com.pfe.pfeoussama.controllers;

import com.pfe.pfeoussama.models.*;
import com.pfe.pfeoussama.payload.request.FormationRequest;
import com.pfe.pfeoussama.payload.request.SalonDisscussionRequest;
import com.pfe.pfeoussama.payload.response.MessageResponse;
import com.pfe.pfeoussama.repository.ProjetRespository;
import com.pfe.pfeoussama.repository.SalonDisscussionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/SalonDiscussion")
public class SalonDiscussionControle {




    @Autowired
    SalonDisscussionRespository salonDisscussionRespository;


    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/PartieProjet";

    @PostMapping("/AddSalonDiscussion")
    public ResponseEntity<?> AddSalonDiscussion(@Valid @RequestBody SalonDisscussionRequest salonDisscussionRequest) {

        SalonDisscussion salonDisscussion = new SalonDisscussion(salonDisscussionRequest.getNom(),salonDisscussionRequest.getImage(),salonDisscussionRequest.getDate());


        salonDisscussionRespository.save(salonDisscussion);



        return ResponseEntity.ok(new MessageResponse("Salon ajouter"));
    }


    @DeleteMapping("/deleteSalonDiscussion/{id}")
    public String deleteSalonDiscussion(@PathVariable String id) {

        salonDisscussionRespository.deleteById(id);

        return "Delete Salon for id " + id;
    }
    @GetMapping("/GetAllSalon")
    public List<SalonDisscussion> getSalon() {
        return salonDisscussionRespository.findAll();
    }





    @PutMapping("/updateSalonDiscussion/{id}")
    public ResponseEntity<SalonDisscussion> updatesalon(@PathVariable("id") String id,@RequestBody SalonDisscussion salonDisscussion) {
        Optional<SalonDisscussion> salonDisscussion1 = salonDisscussionRespository.findById(id);
        if(salonDisscussion1.isPresent())
        {
            SalonDisscussion salon = salonDisscussion1.get();
            salon.setNom(salonDisscussion.getNom());
            salon.setImage(salonDisscussion.getImage());
            return new ResponseEntity<>(salonDisscussionRespository.save(salon), HttpStatus.OK);

        }
         else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @DeleteMapping("/deletesalondiscussion/{id}")
    public ResponseEntity<HttpStatus> deleteSalon(@PathVariable("id") String id) {
        try {
            salonDisscussionRespository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


















}
