package com.chethiya.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "APP_T_POSITION")
public class Position {

    @Id
    @Column(name = "POSITION_ID")
    @GeneratedValue(generator = "APP_S_POSITION", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "APP_S_POSITION", sequenceName = "APP_S_POSITION", allocationSize = 1)
    private int positionId;

    @Column(name = "REF_ID", unique = true)
    private String referenceId;

    @Column(name = "POSITION_NAME")
    private String positionName;

    @Column(name = "TYPE_OF_WORK")
    private String typeOfWork;

    @Column(name = "MONTHLY_SALARY")
    private BigDecimal monthlySalary;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

}
