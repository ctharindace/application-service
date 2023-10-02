package com.chethiya.application.client;

import com.chethiya.application.config.ApplicantServiceClientConfig;
import com.chethiya.application.dto.ApplicantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
@Component
public class ApplicantClient {

    @Autowired
    @Qualifier("applicantService")
    private ApplicantServiceClientConfig applicantServiceConfig;

    public ApplicantDTO getApplicant(String nic) {
        Map<String, String> arguments = Map.of("nic", nic);
        ResponseEntity<ApplicantDTO> responseEntity = new RestTemplate().getForEntity(applicantServiceConfig.getApplicantServiceUri() + "applicant/get/{nic}", ApplicantDTO.class, arguments);
        return responseEntity.getBody();
    }
}
