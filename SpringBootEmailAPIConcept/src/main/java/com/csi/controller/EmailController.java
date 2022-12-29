package com.csi.controller;

import com.csi.model.EmailRequest;
import com.csi.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class EmailController {

    @Autowired
    EmailServiceImpl emailServiceImpl;
    @GetMapping
    public String sayHello(){
        return "WELCOME TO PUNE";
    }


/*
    @PostMapping("/sendmail")
    public ResponseEntity<String> sendMailNewMethod(@RequestBody EmailRequest emailRequest){
        emailServiceImpl.sendEmail(emailRequest);
         return  ResponseEntity.ok("Mail sent");
    }*/

    @PostMapping("/sendmailattach")
    public ResponseEntity<String> senMailWithAttachment(@RequestBody EmailRequest emailRequest)
    {
        emailServiceImpl.sendMailWithAttachment( emailRequest);
        return ResponseEntity.ok( "Mail sent with attachment");
    }

}
