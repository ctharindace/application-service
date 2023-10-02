package com.chethiya.application.controllers;

import com.chethiya.application.dto.ApplicationDTO;
import com.chethiya.application.dto.ApplicationRQ;
import com.chethiya.application.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @ResponseBody
    @PutMapping(path = "/put", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApplicationDTO add(@RequestBody ApplicationDTO dto) {
        return applicationService.saveEntity(dto);
    }

    @ResponseBody
    @PutMapping(path = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApplicationDTO add(@RequestBody ApplicationRQ applicationRQ) {
        return applicationService.createApplication(applicationRQ);
    }
}
