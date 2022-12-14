package com.bloodbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -920714182737082947L;
	public OrderNotFoundException(String msg) {
		super(msg);
	}
}
