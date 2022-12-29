package com.csi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {

    @Id
    @GeneratedValue
    private int emailId;

    private String emailTo;

    private String emailCC;

    private String emailSubject;

    private String emailMessage;

    private String emailAttachment;


}
