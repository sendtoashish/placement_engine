package com.placement.engine.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PlacementEngineRegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlacementEngineRegistrationServiceApplication.class, args);
	}

}
