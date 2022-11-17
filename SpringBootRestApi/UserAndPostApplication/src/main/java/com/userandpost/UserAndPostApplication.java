package com.userandpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserAndPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAndPostApplication.class, args);
	}
	//creating Bean object To RestTemplate
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}

}
