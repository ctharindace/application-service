package com.chethiya.application.client;

import com.chethiya.application.dto.PositionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "position-service")
public interface PositionProxyClient {

    @GetMapping(path = "/position/get/{code}", produces = {MediaType.APPLICATION_JSON_VALUE})
    PositionDTO get(@PathVariable(name = "code") String code);

}
