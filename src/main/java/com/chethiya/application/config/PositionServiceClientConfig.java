package com.chethiya.application.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class PositionServiceClientConfig {

    @Value("${app.chethiya.applicant-service.uri}")
    private String applicantServiceUri;

    @Bean(name="positionService")
    public PositionServiceClientConfig getPositionServiceConfig() {
        return this;
    }
}
