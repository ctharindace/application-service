package com.chethiya.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.chethiya.application.controllers", "com.chethiya.application.services" })
//@EnableJpaRepositories(basePackages = { "com.chethiya.application.dao.repositories" })
//@EntityScan(basePackages = "com.chethiya.application.model")
public class ApplicationService {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationService.class, args);
	}

}
