package com.currency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {
	@GetMapping("/us")
	public String getDollar() {
		return "77.77";
	}
	@GetMapping("/euro")
	public String getEuro() {
		return "81.7457";
	}
	@GetMapping("/kwd")
	public String getKwd() {
		return "252.0144";
	}
	@GetMapping("/uae")
	public String getAeu() { 
		return "96.55";
	}
	@GetMapping("/rupee")
	public String getRupee() {
		return "77.77";
	}
}
