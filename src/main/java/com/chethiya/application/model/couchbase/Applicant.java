package com.chethiya.application.model.couchbase;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class Applicant {

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

    private Set<Passport> passports;

    private String port;
    public void addPassport(Passport passport) {
        if (CollectionUtils.isEmpty(this.passports)) {
            passports = new HashSet<>();
        }
        passports.add(passport);
    }
}