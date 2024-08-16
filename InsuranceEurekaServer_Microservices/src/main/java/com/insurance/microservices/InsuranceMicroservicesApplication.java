package com.insurance.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class InsuranceMicroservicesApplication {

	public static void main(String[] args) {
		System.out.println("This is Eureka Server");
		SpringApplication.run(InsuranceMicroservicesApplication.class, args);
	}

}
