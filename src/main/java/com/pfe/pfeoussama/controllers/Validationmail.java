package com.pfe.pfeoussama.controllers;

import com.pfe.pfeoussama.models.*;
import com.pfe.pfeoussama.payload.request.BlogRequest;
import com.pfe.pfeoussama.payload.request.SignupRequest;
import com.pfe.pfeoussama.payload.response.MessageResponse;
import com.pfe.pfeoussama.repository.FixDateRespository;
import com.pfe.pfeoussama.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/valid")
public class Validationmail {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    FixDateRespository fixDateRespository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/Validmail")
    public Integer validmail(@Valid @RequestBody Mailvalid mailvalid) throws MessagingException {

        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000000000);

        MimeMessage message =javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
        String htmlMsg = "<body  >"
                +"<img   width:  10px;     height:  10px; src='https://image.shutterstock.com/image-photo/elearning-person-using-laptop-on-260nw-1112090363.jpg'>"
                +"<h1 style=color:#00FF00>"+"Bonjour  :"+mailvalid.getName()+" </h1> "

                +"<h1 style=color:blue>"+"Votre code de verification Email sera :"+rand_int1+" </h1>\n "


                +" </body>";
        message.setContent(htmlMsg, "text/html");
        helper.setFrom("gharianioussama24@gmail.com");
        helper.setTo(mailvalid.getMail());
        helper.setSubject("E-lerning Scholi");

        javaMailSender.send(message);

        return rand_int1 ;
    }
    @PostMapping("/validpassword")
    public Integer validpassword(@Valid @RequestBody Mailvalid mailvalid) throws MessagingException {

        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000000000);

        MimeMessage message =javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
        String htmlMsg = "<body  >"
                +"<img   width:  10px;     height:  10px; src='https://image.shutterstock.com/image-photo/elearning-person-using-laptop-on-260nw-1112090363.jpg'>"
                +"<h1 style=color:#00FF00>"+"Bonjour Votre email est :"+mailvalid.getMail()+" </h1> "

                +"<h1 style=color:blue>"+"Votre Code pour recuperer  Password sera :"+rand_int1+" </h1>\n "


                +" </body>";
        message.setContent(htmlMsg, "text/html");
        helper.setFrom("gharianioussama24@gmail.com");
        helper.setTo(mailvalid.getMail());
        helper.setSubject("E-lerning Scholi");

        javaMailSender.send(message);

        return rand_int1 ;
    }
    @PostMapping("/validname")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Email is already in use!"));
        }
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
    @PostMapping("/contact")
    public ResponseEntity<?>contact(@Valid @RequestBody Contactmail contactmail) throws MessagingException {



        MimeMessage message =javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
        String htmlMsg = "<body  >"
                +"<img   width:  10px;     height:  10px; src='https://image.shutterstock.com/image-photo/elearning-person-using-laptop-on-260nw-1112090363.jpg'>"
                +"<h1 style=color:black>"+"Name  sera   :"+contactmail.getName()+" </h1> "

                +"<h1 style=color:blue>"+" Email sera :"+contactmail.getMail()+" </h1>\n "
                +"<h1 style=color:blue>"+" Description sera :"+contactmail.getMessage()+" </h1>\n "

                +" </body>";
        message.setContent(htmlMsg, "text/html");
        helper.setFrom(contactmail.getMail());
        helper.setTo("gharianioussama24@gmail.com");
        helper.setSubject(contactmail.getSubj());

        javaMailSender.send(message);

        return ResponseEntity.ok(new MessageResponse("Message sender successfully!"));
    }
    @GetMapping("/findbyidformateur/{IdFormateur}")
    public List<FixDate> getformationByidFormateur(@PathVariable("IdFormateur") String IdFormateur){
        List<FixDate> fixDates = this.fixDateRespository.findByIdFormateur(IdFormateur);

        return fixDates;
    }
    @DeleteMapping("/deleteformationformateur/{id}")
    public ResponseEntity<HttpStatus> deleteformationformateur(@PathVariable("id") String id) {
        try {
            fixDateRespository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateFormationformateur/{id}")
    public ResponseEntity<FixDate> updateFormationformateur(@PathVariable("id") String id, @RequestBody FixDate fixDate) throws MessagingException {
        Optional<FixDate> fixDate1 = fixDateRespository.findById(id);
        if(fixDate1.isPresent())
        {
            FixDate use = fixDate1.get();
            use.setDate(fixDate.getDate());
            List<User> users = this.userRepository.findAll();
            for (int i=0;i<users.size();i++)
            { String mail="";
                mail= users.get(i).getEmail();
                MimeMessage message =javaMailSender.createMimeMessage();

                MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
                String htmlMsg = "<body  >"
                        +"<img   width:  10px;     height:  10px; src='https://image.shutterstock.com/image-photo/elearning-person-using-laptop-on-260nw-1112090363.jpg'>"
                        +"<h1 style=color:#00FF00>"+"Bonjour Mes Etudiants il ya une modification pour la date de meeting"+fixDate.getDate()+" </h1> "




                        +"<h1 style=color:purple>"+"Votre  Formateur   :"+fixDate.getNomf()+" </h1>\n "
                        +"<h1 style=color:yellow>"+"Votre Lien de Meeting :"+fixDate.getLienmeet()+" </h1>\n "

                        +" </body>";
                message.setContent(htmlMsg, "text/html");
                helper.setFrom("gharianioussama24@gmail.com");
                helper.setTo(mail);
                helper.setSubject("E-lerning Scholi");

                javaMailSender.send(message);



            }

            return new ResponseEntity<>(fixDateRespository.save(use), HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @PutMapping("/updatestartmeeting/{id}")
    public ResponseEntity<FixDate> updatestartmeeting(@PathVariable("id") String id, @RequestBody FixDate fixDate) throws MessagingException {
        Optional<FixDate> fixDate1 = fixDateRespository.findById(id);
        if(fixDate1.isPresent())
        {
            FixDate use = fixDate1.get();
            use.setOver(fixDate.isOver());



            return new ResponseEntity<>(fixDateRespository.save(use), HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}
