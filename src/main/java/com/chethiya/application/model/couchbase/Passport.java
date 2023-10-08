package com.chethiya.application.model.couchbase;

import lombok.Data;

import java.util.Date;

@Data
public class Passport {

    private Integer passportId;

    private Applicant applicant;

    private String passportNumber;

    private Date dateOfIssue;

    private Date dateOfExpiry;

    private String countryCodeOfIssue;

}
