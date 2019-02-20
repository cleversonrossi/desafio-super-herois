package com.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.desafio.config.SuperHeroisProperty;

@SpringBootApplication
@EnableConfigurationProperties(SuperHeroisProperty.class)
public class DesafioSuperHeroisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioSuperHeroisApplication.class, args);
	}

}

