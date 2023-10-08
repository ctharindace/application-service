package com.chethiya.application.model.couchbase;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Data
@Document
public class Application {
    @Id
    private String applicationId;

    @Field
    private Applicant applicant;

    @Field
    private Position position;

}
