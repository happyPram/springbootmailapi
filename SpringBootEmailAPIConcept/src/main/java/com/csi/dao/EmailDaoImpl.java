package com.csi.dao;

import com.csi.model.EmailRequest;
import com.csi.repo.EmailRepo;
import com.csi.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

@Component
public class EmailDaoImpl {

    @Autowired
    EmailRepo emailRepo;

    @Autowired
     JavaMailSender javaMailSender;



    //Using application.properties
    public void sendMail(EmailRequest emailRequest)
    {
        emailRepo.save(emailRequest);
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom("pranalipokale44@gmail.com");
        message.setTo( emailRequest.getEmailTo());
        message.setCc(emailRequest.getEmailCC());
        message.setText(emailRequest.getEmailMessage());
        message.setSubject(emailRequest.getEmailSubject());

        javaMailSender.send(message);
        System.out.println("Mail sent");
    }

    public void sendMailWithAttachement(EmailRequest emailRequest)
    {
          MimeMessage mimeMessage=javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom("pranalipokale44@gmail.com");
            mimeMessageHelper.setTo(emailRequest.getEmailTo());
            mimeMessageHelper.setText(emailRequest.getEmailMessage());
            mimeMessageHelper.setSubject(emailRequest.getEmailSubject());
            mimeMessageHelper.setCc(emailRequest.getEmailCC());

            FileSystemResource fileSystemResource=new FileSystemResource(new File(emailRequest.getEmailAttachment()));
            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
            emailRepo.save(emailRequest);
            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }
}
