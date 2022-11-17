package com.airlines.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PassengerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PassengerNotFoundException(String msg) {
		super(msg);
	}
}
