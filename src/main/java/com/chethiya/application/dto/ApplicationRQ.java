package com.chethiya.application.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApplicationRQ implements Serializable {

    private String nic;

    private String positionCode;

}
