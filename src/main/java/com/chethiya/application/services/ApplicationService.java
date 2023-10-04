package com.chethiya.application.services;

import com.chethiya.application.dto.ApplicantDTO;
import com.chethiya.application.dto.ApplicationDTO;
import com.chethiya.application.dto.ApplicationRQ;

public interface ApplicationService {

    ApplicationDTO saveEntity(ApplicationDTO applicationDTO);

    ApplicationDTO createApplication(ApplicationRQ applicationRQ);

    ApplicantDTO getApplicant(String nic);
}
