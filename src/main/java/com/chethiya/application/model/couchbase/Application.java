package com.chethiya.application.model.couchbase;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.Date;

@Data
@Document
public class Application {
    @Id
    private String nic;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private String gender;
    @Field
    private Date dateOfBirth;
    @Field
    private String maritalStatus;
    @Field
    private Integer noOfChildren;
    @Field
    private Double weight;
    @Field
    private Double height;
    @Field
    private String complexion;
    @Field
    private String eduQualificationGrade;

}
