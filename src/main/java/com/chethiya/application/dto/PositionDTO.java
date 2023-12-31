package com.chethiya.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PositionDTO implements Serializable {

    private String referenceId;

    private String positionName;

    private BigDecimal monthlySalary;

    private String typeOfWorkCode;

    private String typeOfWorkName;

    private Date startDate;

    private Date endDate;

}