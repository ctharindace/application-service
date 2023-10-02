package com.chethiya.application.services.impl;

import com.chethiya.application.client.ApplicantClient;
import com.chethiya.application.dao.couchbase.repositories.ApplicationRepository;
import com.chethiya.application.dto.ApplicantDTO;
import com.chethiya.application.dto.ApplicationDTO;
import com.chethiya.application.dto.ApplicationRQ;
import com.chethiya.application.model.couchbase.Application;
import com.chethiya.application.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicantClient applicantClient;

    @Override
    public ApplicationDTO createApplication(ApplicationRQ applicationRQ) {
        ApplicantDTO applicantDTO = applicantClient.getApplicant(applicationRQ.getNic());
        Application application = applicationRepository.save(getApplication(applicantDTO));
        return getApplicantDTO(application);
    }

    @Override
    public ApplicationDTO saveEntity(ApplicationDTO applicationDTO) {
        Application application = applicationRepository.save(getApplication(applicationDTO));
        return getApplicantDTO(application);
    }

    private static Application getApplication(ApplicantDTO applicationDTO) {
        Application application = new Application();
        application.setFirstName(applicationDTO.getFirstName());
        application.setLastName(applicationDTO.getLastName());
        application.setDateOfBirth(applicationDTO.getDateOfBirth());
        application.setNic(applicationDTO.getNic());
        application.setGender(applicationDTO.getGender());
        application.setMaritalStatus(applicationDTO.getMaritalStatus());
        application.setNoOfChildren(applicationDTO.getNoOfChildren());
        application.setWeight(applicationDTO.getWeight());
        application.setHeight(applicationDTO.getHeight());
        application.setComplexion(applicationDTO.getComplexion());
        application.setEduQualificationGrade(applicationDTO.getEduQualificationGrade());
        return application;
    }


    private static ApplicationDTO getApplicantDTO(Application application) {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        if (application != null) {
            applicationDTO.setFirstName(application.getFirstName());
            applicationDTO.setLastName(application.getLastName());
            applicationDTO.setDateOfBirth(application.getDateOfBirth());
            applicationDTO.setNic(application.getNic());
            applicationDTO.setGender(application.getGender());
            applicationDTO.setMaritalStatus(application.getMaritalStatus());
            applicationDTO.setNoOfChildren(application.getNoOfChildren());
            applicationDTO.setWeight(application.getWeight());
            applicationDTO.setHeight(application.getHeight());
            applicationDTO.setComplexion(application.getComplexion());
            applicationDTO.setEduQualificationGrade(application.getEduQualificationGrade());
        }
        return applicationDTO;
    }

    private static Application getApplication(ApplicationDTO applicationDTO) {
        Application application = new Application();
        application.setFirstName(applicationDTO.getFirstName());
        application.setLastName(applicationDTO.getLastName());
        application.setDateOfBirth(applicationDTO.getDateOfBirth());
        application.setNic(applicationDTO.getNic());
        application.setGender(applicationDTO.getGender());
        application.setMaritalStatus(applicationDTO.getMaritalStatus());
        application.setNoOfChildren(applicationDTO.getNoOfChildren());
        application.setWeight(applicationDTO.getWeight());
        application.setHeight(applicationDTO.getHeight());
        application.setComplexion(applicationDTO.getComplexion());
        application.setEduQualificationGrade(applicationDTO.getEduQualificationGrade());
        return application;
    }
}
