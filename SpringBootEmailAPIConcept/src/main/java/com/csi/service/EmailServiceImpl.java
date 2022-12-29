package com.csi.service;

import com.csi.dao.EmailDaoImpl;
import com.csi.model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

    @Autowired
    EmailDaoImpl emailDaoImpl;


    public void sendEmail(EmailRequest emailRequest)
    {
         emailDaoImpl.sendMail(emailRequest);
    }
    public void sendMailWithAttachment(EmailRequest emailRequest)
    {
        emailDaoImpl.sendMailWithAttachement(emailRequest);
    }
}
