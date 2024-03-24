package com.andre.msfolhapagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "ms-trabalhadores")
@SpringBootApplication
@EnableFeignClients
public class MsFolhapagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFolhapagamentoApplication.class, args);
	}

}
