package com.example.Eureka_server_proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerProjApplication.class, args);
		System.out.println("Eureka Server is running...");
	}
	

}
