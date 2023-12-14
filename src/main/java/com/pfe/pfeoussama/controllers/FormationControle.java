package com.pfe.pfeoussama.controllers;

import com.pfe.pfeoussama.models.*;
import com.pfe.pfeoussama.payload.request.ChapitreRequest;
import com.pfe.pfeoussama.payload.request.FormationRequest;
import com.pfe.pfeoussama.payload.response.MessageResponse;
import com.pfe.pfeoussama.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Formation")
public class FormationControle {
    @Autowired
    FormationRespository formationRespository;
    @Autowired
    CertificatRespotiory certificatRespotiory;

    @Autowired
    ChapitreRespository chapitreRespository;

    @Autowired
    LeceonRespository leceonRespository;

    @Autowired
    ProjetRespository projetRespository;


    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp";
    private final Path root = Paths.get("/src/main/webapp");


    @DeleteMapping("/deleteformation/{id}")
    public ResponseEntity<HttpStatus> deleteSalon(@PathVariable("id") String id) {
        try {
            formationRespository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


/*
    @PostMapping("/AddLeceon")
    public ResponseEntity<?> RegisterLeceon(@Valid @RequestBody LeceonRequest leceonRequest) {
        Leceon leceon = new Leceon(leceonRequest.getName(),leceonRequest.getCour(),leceonRequest.getQuiz(),leceonRequest.getVideo(),leceonRequest.getIdChapitre(),leceonRequest.getDate());
        leceonRespository.save(leceon);
        return ResponseEntity.ok(new MessageResponse("Leceon ajouter"));
    }*/


    @PostMapping("/AddFormation")
    public ResponseEntity<?> registerUser(@Valid @RequestBody FormationRequest formationRequest) {

        Fomation formation = new Fomation(formationRequest.getName(),formationRequest.getType(),formationRequest.getImage(),formationRequest.getDate());


        formationRespository.save(formation);



        return ResponseEntity.ok(new MessageResponse("Formation ajouter"));
    }

    @GetMapping("/getf")
    public List<Fomation> getAllFormation() {
        return formationRespository.findAll();
    }






    @PostMapping("/AddChapitre")
    public ResponseEntity<?> AddChapitre(@Valid @RequestBody ChapitreRequest chapitreRequest) {

        Chapitre chapitre = new Chapitre(chapitreRequest.getName(),chapitreRequest.getIdFormation(),chapitreRequest.getDate() );


        chapitreRespository.save(chapitre);



        return ResponseEntity.ok(new MessageResponse("Chapitre ajouter"));
    }

    @GetMapping("/finds/{IdChapitre}")
    public List<Leceon> getByIdchapitre(@PathVariable("IdChapitre") String IdChapitre){
        List<Leceon> leceons = this.leceonRespository.findByIdChapitre(IdChapitre);

        return leceons;
    }

    @GetMapping("/find/{IdFormation}")
    public List<Chapitre> getByCity(@PathVariable("IdFormation") String IdFormation){
        List<Chapitre> chap = this.chapitreRespository.findByIdFormation(IdFormation);

        return chap;
    }
    @GetMapping("/count/{IdChapitre}")
    public long count(@PathVariable("IdChapitre") String IdChapitre){
        List<Leceon> leceons = this.leceonRespository.findByIdChapitre(IdChapitre);

        return leceons.size();
    }


    @PutMapping("/uodateformation/{id}")
    public ResponseEntity<Fomation> updateformation(@PathVariable("id") String id, @RequestBody Fomation fomation) {
        Optional<Fomation> blog1 = formationRespository.findById(id);
        if(blog1.isPresent())
        {
            Fomation use = blog1.get();
            use.setName(fomation.getName());
            use.setImage(fomation.getImage());
            use.setType(fomation.getType());


            return new ResponseEntity<>(formationRespository.save(use), HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @PutMapping("/updatechapitre/{id}")
    public ResponseEntity<Chapitre> updatechapitre(@PathVariable("id") String id, @RequestBody Chapitre chapitre) {
        Optional<Chapitre> blog1 = chapitreRespository.findById(id);
        if(blog1.isPresent())
        {
            Chapitre use = blog1.get();
            use.setName(chapitre.getName());



            return new ResponseEntity<>(chapitreRespository.save(use), HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @DeleteMapping("/deletechapitre/{id}")
    public ResponseEntity<HttpStatus> deletechapitre(@PathVariable("id") String id) {
        try {
            chapitreRespository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deletelecon/{id}")
    public ResponseEntity<HttpStatus> deletelecon(@PathVariable("id") String id) {
        try {
            leceonRespository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getallprojet")
    public List<Projet> getAllprojet() {
        return projetRespository.findAll();
    }


    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @GetMapping("/findbyidcertif/{IdUser}")
    public List<Certifica> getbyidff(@PathVariable("IdUser") String IdUser){
        List<Certifica> certificas = this.certificatRespotiory.findByIdUser(IdUser);

        return certificas;
    }
    @DeleteMapping("/deletecertif/{id}")
    public ResponseEntity<HttpStatus> deletecertif(@PathVariable("id") String id) {
        try {
            certificatRespotiory.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/Getaalcertif")
    public List<Certifica> getallcertif() {
        return certificatRespotiory.findAll();
    }

    @GetMapping("/files/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = load(filename);
        return ResponseEntity.ok()
                .header(CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    @GetMapping("download/{filename}")
    public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
        Path filePath = get(uploadDirectory).toAbsolutePath().normalize().resolve(filename);
        if(!Files.exists(filePath)) {
            throw new FileNotFoundException(filename + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", filename);
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders).body(resource);
    }








    @PostMapping( value ="/upload" ,consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") @Valid @NotNull @NotEmpty List<MultipartFile> multipartFiles) throws IOException {
        List<String> filenames = new ArrayList<>();
        for(MultipartFile file : multipartFiles) {
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            Path fileStorage = get(uploadDirectory, filename).toAbsolutePath().normalize();
            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
            filenames.add(filename);
        }
        return ResponseEntity.ok().body(filenames);
    }


}
