package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PostRestFullApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostRestFullApplication.class, args);
	}
	//This method create bean object in restTemplate
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
