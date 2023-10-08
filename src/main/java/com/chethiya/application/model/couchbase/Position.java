package com.chethiya.application.model.couchbase;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Position {

    private String referenceId;

    private String positionName;

    private BigDecimal monthlySalary;

    private String typeOfWorkCode;

    private String typeOfWorkName;

    private Date startDate;

    private Date endDate;

}