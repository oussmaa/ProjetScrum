package com.pfe.pfeoussama.controllers;

import com.pfe.pfeoussama.models.FixDate;
import com.pfe.pfeoussama.models.Leceon;
import com.pfe.pfeoussama.models.Projet;
import com.pfe.pfeoussama.models.User;
import com.pfe.pfeoussama.payload.response.MessageResponse;
import com.pfe.pfeoussama.repository.FixDateRespository;
import com.pfe.pfeoussama.repository.LeceonRespository;
import com.pfe.pfeoussama.repository.ProjetRespository;
import com.pfe.pfeoussama.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.validation.Valid;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class testcon {
    @Autowired
    private LeceonRespository leceonRespository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    ServletContext context;



    @Autowired
    ProjetRespository projetRespository;



    @Autowired
    UserRepository userRepository;


    @Autowired
    FixDateRespository fixDateRespository;


    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp";




    @Autowired
    private JavaMailSender javaMailSender;



    @RequestMapping(value = "EnvoyerEmail", method = RequestMethod.POST)
    @ResponseBody
    void sendEmail(@Valid @RequestBody FixDate fixDate) throws MessagingException {

        List<User> users = this.userRepository.findAll();
for (int i=0;i<users.size();i++)
{ String mail="";
   mail= users.get(i).getEmail();
    MimeMessage message =javaMailSender.createMimeMessage();

    MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
    String htmlMsg = "<body  >"
            +"<img   width:  10px;     height:  10px; src='https://image.shutterstock.com/image-photo/elearning-person-using-laptop-on-260nw-1112090363.jpg'>"
            +"<h1 style=color:#00FF00>"+"Votre Reunion est Programer le"+fixDate.getDate()+" </h1> "

            +"<h1 style=color:blue>"+"Votre Formateur sera :"+fixDate.getNomf()+" </h1>\n "
            +"<h1 style=color:yellow>"+"Votre Type de Meeting :"+fixDate.getType()+" </h1>\n "


            +"<h1 style=color:purple>"+"Votre Formation a le nom   :"+fixDate.getTitre()+" </h1>\n "
            +"<h1 style=color:yellow>"+"Votre Lien de Meeting :"+fixDate.getLienmeet()+" </h1>\n "

            +" </body>";
    message.setContent(htmlMsg, "text/html");
    helper.setFrom("gharianioussama24@gmail.com");
    helper.setTo(mail);
    helper.setSubject("E-lerning Scholi");

    javaMailSender.send(message);
    fixDateRespository.save(fixDate);


}

    }
    @GetMapping("/finds/{IdChapitre}")
    public List<Leceon> getByIdchapitre(@PathVariable("IdChapitre") String IdChapitre){
        List<Leceon> leceons = this.leceonRespository.findByIdChapitre(IdChapitre);

        return leceons;
    }







    @GetMapping("/GetAllMetting/{IdFormateur}")
    public List<FixDate> getrenieon(@PathVariable("IdFormateur") String IdFormateur) {

        return fixDateRespository.findByIdFormateur(IdFormateur);
    }

        @GetMapping("/GetAllProjet")
    public List<Projet> getSalon() {
        return projetRespository.findAll();
    }



    @GetMapping("/getallmetting")
    public List<FixDate> gettoutmeet() {
        return fixDateRespository.findAll();
    }




    @DeleteMapping("/deleteprojet/{id}")
    public ResponseEntity<HttpStatus> deleteprojet(@PathVariable("id") String id) {
        try {
            projetRespository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }










    @RequestMapping(value = "AddLeceon", headers = "Content-Type= multipart/form-data",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<MessageResponse> saveStudent(@RequestPart("img") MultipartFile file, @RequestPart("kiki") MultipartFile Cour)throws IOException {


        String filename = file.getOriginalFilename();
        String filename2 = Cour.getOriginalFilename();
        Path fileNameAndPath = Paths.get(uploadDirectory, filename);
        Path fileNameAndPath2 = Paths.get(uploadDirectory, filename2);

        try {
            Files.write(fileNameAndPath, file.getBytes());
            Files.write(fileNameAndPath2, Cour.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
       // stu.setVideo(filename);
       // stu.setCour(filename2);
       // leceonRespository.save(stu);
        return ResponseEntity.ok(new MessageResponse("Data Added"));
    }
    @RequestMapping(value = "AddProjet", method = RequestMethod.POST )
    @ResponseBody
    public String saveProjet(Projet projet, @RequestParam("file") MultipartFile file ) {
        StringBuilder fileNames = new StringBuilder();
        String filename = file.getOriginalFilename();

        Path fileNameAndPath = Paths.get(uploadDirectory, filename);


        try {
            Files.write(fileNameAndPath, file.getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        }
        projet.setTypeprojet(filename);

        projetRespository.save(projet);
        return "Save Data Successfully ! ";
    }

    @GetMapping("/findLeceonbyid/{id}")
    public Optional<Leceon> getByCity(@PathVariable("id") String id) {
        Optional<Leceon> leceon = this.leceonRespository.findById(id);

        return leceon;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
    @GetMapping(path = "/download/{fileName}")
            String downLoadSingleFile(@PathVariable String fileName) throws IOException{
        String x=  Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(context.getRealPath("/imagedata/")+fileName)));

return "data:video/mp4;base64,"+x;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
    @GetMapping(path = "/downloadpdf/{fileName}")
    String downLoadSingleFilepdf(@PathVariable String fileName) throws IOException {
        String x=  Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(context.getRealPath("/imagedata/")+fileName)));

        return "data:application/pdf;base64,"+x;
    }
    @GetMapping(path = "/test2/{fileName}")
    @ResponseBody
        ResponseEntity<ByteArrayResource> downLoadSinglecFilepdf(@PathVariable String fileName) throws IOException {

        Path filename1 =Paths.get("imagedata",fileName);
        byte[] buffer=Files.readAllBytes(filename1);
        ByteArrayResource byteArrayResource=new ByteArrayResource(buffer);
        return  ResponseEntity.ok().contentLength(buffer.length).contentType(MediaType.ALL).body(byteArrayResource);


     }
}

