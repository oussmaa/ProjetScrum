package com.pfe.pfeoussama.controllers;

import com.pfe.pfeoussama.models.*;
import com.pfe.pfeoussama.payload.request.BlogRequest;
import com.pfe.pfeoussama.payload.request.Certificarequest;
import com.pfe.pfeoussama.payload.request.FormationRequest;
import com.pfe.pfeoussama.payload.request.NotificationRequest;
import com.pfe.pfeoussama.payload.response.MessageResponse;
import com.pfe.pfeoussama.repository.BlogRespository;
import com.pfe.pfeoussama.repository.CertificatRespotiory;
import com.pfe.pfeoussama.repository.FormationRespository;
import com.pfe.pfeoussama.repository.MessageRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Certificate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Blog")
public class AddBlogControle {
    @Autowired
    BlogRespository blogRespository;


    @Autowired
    MessageRespository messageRespository;

    @Autowired
    CertificatRespotiory certificatRespotiory;

    @PostMapping("/AddBlog")
    public ResponseEntity<?> AddBlog(@Valid @RequestBody BlogRequest blogRequest) {

        Blog blog = new Blog(blogRequest.getIdUser(),blogRequest.getImage(),blogRequest.getDescription(),blogRequest.getDegration(),blogRequest.getDate(),blogRequest.getTech(),blogRequest.getName());


        blogRespository.save(blog);



        return ResponseEntity.ok(new MessageResponse("Blog Added"));
    }

    @GetMapping("/GetAllBlog")
    public List<Blog> getAllEmployees() {
        return blogRespository.findAll();
    }

    @DeleteMapping("/deleteblog/{id}")
    public ResponseEntity<HttpStatus> deleteblog(@PathVariable("id") String id) {
        try {
            blogRespository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/findblogbyid/{id}")
    public Optional<Blog> getbyid(@PathVariable("id") String id){
        Optional<Blog> blog = this.blogRespository.findById(id);

        return blog;
    }

    @GetMapping("/findbyiduser/{IdUser}")
    public List<Blog> getbuiduser(@PathVariable("IdUser") String IdUser){
        List<Blog> blog = this.blogRespository.findByIdUser(IdUser);

        return blog;
    }


    @PutMapping("/ubdateBlog/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") String id, @RequestBody Blog blog) {
        Optional<Blog> blog1 = blogRespository.findById(id);
        if(blog1.isPresent())
        {
            Blog use = blog1.get();
            use.setDate(blog.getDate());
            use.setImage(blog.getImage());
            use.setTech(blog.getTech());
            use.setDescription(blog.getDescription());
            return new ResponseEntity<>(blogRespository.save(use), HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @GetMapping("/findbyidcertif/{IdUser}")
    public List<Certifica> getbyidff(@PathVariable("IdUser") String IdUser){
        List<Certifica> certificas = this.certificatRespotiory.findByIdUser(IdUser);

        return certificas;
    }
    @PostMapping("/AddCertif")
    public ResponseEntity<?> addcertif(@Valid @RequestBody Certificarequest certificarequest) {


        Certifica notif = new Certifica(certificarequest.getIdUser(), certificarequest.getType(),certificarequest.getNameUser(),certificarequest.getNameformation(),certificarequest.getDate());

        certificatRespotiory.save(notif);



        return ResponseEntity.ok(new MessageResponse("Certif ajouter"));
    }

}
