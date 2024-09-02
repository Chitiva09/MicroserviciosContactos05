package com.example.microservicio_cliente_contacto_05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroservicioClienteContacto05Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioClienteContacto05Application.class, args);

	}
	
	
	@Bean
	public RestTemplate template (){
		return new RestTemplate();
	}

}