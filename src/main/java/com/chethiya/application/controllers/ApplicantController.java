package com.chethiya.application.controllers;

import com.chethiya.application.dto.ApplicantDTO;
import com.chethiya.application.services.ApplicantService;
import com.chethiya.application.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("applicant")
public class ApplicantController extends CommonController<ApplicantDTO, String> {

    @Autowired
    private ApplicantService applicantService;

    @Override
    CommonService<ApplicantDTO, String> getService() {
        return this.applicantService;
    }
}
