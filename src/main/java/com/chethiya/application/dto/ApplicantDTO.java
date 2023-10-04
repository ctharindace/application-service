package com.chethiya.application.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ApplicantDTO {
    private String firstName;

    private String lastName;

    private String nic;

    private Date dateOfBirth;

    private String gender;

    private String maritalStatus;

    private Integer noOfChildren;

    private Double weight;

    private Double height;

    private String complexion;

    private String eduQualificationGrade;

    private String port;

}
