package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ResponseUserAndPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResponseUserAndPostApplication.class, args);
	}
	//Creating bean object for restTemplate
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
