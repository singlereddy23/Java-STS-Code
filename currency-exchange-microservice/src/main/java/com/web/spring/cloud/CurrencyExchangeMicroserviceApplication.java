package com.web.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CurrencyExchangeMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeMicroserviceApplication.class, args);
		System.out.println("Currency Exchange Service is Running...");
	}

}
