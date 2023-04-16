package com.web.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UmsSpringBootAppApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(UmsSpringBootAppApplication.class, args);
		System.out.println("App is Running...");
	}
}