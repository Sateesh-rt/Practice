package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EServiceRegistryyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EServiceRegistryyApplication.class, args);
	}

}
