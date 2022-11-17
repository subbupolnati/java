package com.currency.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {
	
	RestTemplate  template;
	
	public CurrencyService(RestTemplate template) {
		super();
		this.template = template;
	}


	public String searchCurrencyRates(String currency)
	{
		
		return template.getForObject("http://localhost:8081/"+currency, String.class);
	}
}
