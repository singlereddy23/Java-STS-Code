package com.web.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaNamingServiceappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaNamingServiceappApplication.class, args);
		System.out.println("Eureka Server is running...");
	}

}
