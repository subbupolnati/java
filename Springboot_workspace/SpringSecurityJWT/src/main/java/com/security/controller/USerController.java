package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class USerController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return"this is welcome page";
	}

}
