package com.chethiya.application.services.impl;

import com.chethiya.application.client.ApplicantProxyClient;
import com.chethiya.application.client.PositionProxyClient;
import com.chethiya.application.dao.couchbase.repositories.ApplicationRepository;
import com.chethiya.application.dto.ApplicantDTO;
import com.chethiya.application.dto.ApplicationDTO;
import com.chethiya.application.dto.ApplicationRQ;
import com.chethiya.application.dto.PassportDTO;
import com.chethiya.application.dto.PositionDTO;
import com.chethiya.application.model.couchbase.Applicant;
import com.chethiya.application.model.couchbase.Application;
import com.chethiya.application.model.couchbase.Passport;
import com.chethiya.application.model.couchbase.Position;
import com.chethiya.application.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicantProxyClient applicantClient;

    @Autowired
    private PositionProxyClient positionClient;

    @Override
    public ApplicationDTO createApplication(ApplicationRQ applicationRQ) {
        ApplicantDTO applicantDTO = applicantClient.get(applicationRQ.getNic());
        PositionDTO positionDTO = positionClient.get(applicationRQ.getPositionRefId());
        Application application = applicationRepository.save(getApplication(applicantDTO,  positionDTO));
        return getApplicantDTO(application);
    }

    @Override
    public ApplicantDTO getApplicant(String nic) {
        return applicantClient.get(nic);
    }

    @Override
    public ApplicationDTO saveEntity(ApplicationDTO applicationDTO) {
        Application application = applicationRepository.save(getApplication(applicationDTO.getApplicantDTO(),
                applicationDTO.getPositionDTO()));
        return getApplicantDTO(application);
    }

    private Application getApplication(ApplicantDTO applicantDTO, PositionDTO positionDTO) {
        Application application = new Application();
        application.setApplicationId(applicantDTO.getNic() + "_" + positionDTO.getReferenceId());
        application.setApplicant(getApplicant(applicantDTO));
        application.setPosition(getPosition(positionDTO));
        return application;
    }


    private ApplicationDTO getApplicantDTO(Application application) {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        if (application != null) {
            applicationDTO.setApplicantDTO(getApplicantDTO(application.getApplicant()));
            applicationDTO.setPositionDTO(getPositionDTO(application.getPosition()));
        }
        return applicationDTO;
    }

    private PositionDTO getPositionDTO(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositionName(position.getPositionName());
        positionDTO.setReferenceId(position.getReferenceId());
        positionDTO.setMonthlySalary(position.getMonthlySalary());
        positionDTO.setTypeOfWorkCode(position.getTypeOfWorkCode());
        positionDTO.setTypeOfWorkName(position.getTypeOfWorkName());
        positionDTO.setStartDate(position.getStartDate());
        positionDTO.setEndDate(position.getEndDate());
        return positionDTO;
    }

    private Position getPosition(PositionDTO positionDTO) {
        Position position = new Position();
        position.setPositionName(positionDTO.getPositionName());
        position.setReferenceId(positionDTO.getReferenceId());
        position.setMonthlySalary(positionDTO.getMonthlySalary());
        position.setTypeOfWorkCode(positionDTO.getTypeOfWorkCode());
        position.setTypeOfWorkName(positionDTO.getTypeOfWorkName());
        position.setStartDate(positionDTO.getStartDate());
        position.setEndDate(positionDTO.getEndDate());
        return position;
    }

    private ApplicantDTO getApplicantDTO(Applicant applicant) {
        ApplicantDTO applicantDTO = new ApplicantDTO();
        if (applicant != null) {
            applicantDTO.setFirstName(applicant.getFirstName());
            applicantDTO.setLastName(applicant.getLastName());
            applicantDTO.setDateOfBirth(applicant.getDateOfBirth());
            applicantDTO.setNic(applicant.getNic());
            applicantDTO.setGender(applicant.getGender());
            applicantDTO.setMaritalStatus(applicant.getMaritalStatus());
            applicantDTO.setNoOfChildren(applicant.getNoOfChildren());
            applicantDTO.setWeight(applicant.getWeight());
            applicantDTO.setHeight(applicant.getHeight());
            applicantDTO.setComplexion(applicant.getComplexion());
            applicantDTO.setEduQualificationGrade(applicant.getEduQualificationGrade());
            if (!CollectionUtils.isEmpty(applicant.getPassports())) {
                applicantDTO.setPassports(applicant.getPassports().stream().map(this::getPassportDTO).collect(Collectors.toSet()));
            }
        }
        return applicantDTO;
    }

    private Applicant getApplicant(ApplicantDTO applicantDTO) {
        Applicant applicant = new Applicant();
        applicant.setFirstName(applicantDTO.getFirstName());
        applicant.setLastName(applicantDTO.getLastName());
        applicant.setDateOfBirth(applicantDTO.getDateOfBirth());
        applicant.setNic(applicantDTO.getNic());
        applicant.setGender(applicantDTO.getGender());
        applicant.setMaritalStatus(applicantDTO.getMaritalStatus());
        applicant.setNoOfChildren(applicantDTO.getNoOfChildren());
        applicant.setWeight(applicantDTO.getWeight());
        applicant.setHeight(applicantDTO.getHeight());
        applicant.setComplexion(applicantDTO.getComplexion());
        applicant.setEduQualificationGrade(applicantDTO.getEduQualificationGrade());
        if (!CollectionUtils.isEmpty(applicantDTO.getPassports())) {
            applicantDTO.getPassports().forEach(pp -> applicant.addPassport(getPassport(pp)));
        }
        return applicant;
    }

    private Passport getPassport(PassportDTO passportDTO) {
        Passport passport = new Passport();
        passport.setPassportNumber(passportDTO.getPassportNumber());
        passport.setDateOfExpiry(passportDTO.getDateOfExpiry());
        passport.setCountryCodeOfIssue(passportDTO.getCountryCodeOfIssue());
        passport.setDateOfIssue(passportDTO.getDateOfIssue());
        return passport;
    }

    private PassportDTO getPassportDTO(Passport passport) {
        PassportDTO passportDTO = new PassportDTO();
        passportDTO.setPassportNumber(passport.getPassportNumber());
        passportDTO.setDateOfExpiry(passport.getDateOfExpiry());
        passportDTO.setCountryCodeOfIssue(passport.getCountryCodeOfIssue());
        passportDTO.setDateOfIssue(passport.getDateOfIssue());
        return passportDTO;
    }
}
