package com.chethiya.application.client;

import com.chethiya.application.dto.ApplicantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="applicant-service")
public interface ApplicantProxyClient {

    @GetMapping(path = "/get/{code}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ApplicantDTO get(@PathVariable(name = "code") String nic);

}
