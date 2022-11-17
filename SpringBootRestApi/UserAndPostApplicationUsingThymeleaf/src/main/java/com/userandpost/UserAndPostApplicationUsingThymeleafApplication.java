package com.userandpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserAndPostApplicationUsingThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAndPostApplicationUsingThymeleafApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
