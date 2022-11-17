package com.dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {

	@GetMapping("/")
	public String home() {
		return "this is second dev tool application";
	}
}
