package com.andre.mstrabalhadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsTrabalhadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTrabalhadoresApplication.class, args);
	}

}
