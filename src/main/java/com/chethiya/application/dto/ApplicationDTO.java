package com.chethiya.application.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApplicationDTO implements Serializable {

    private ApplicantDTO applicantDTO;

    private PositionDTO positionDTO;

}
