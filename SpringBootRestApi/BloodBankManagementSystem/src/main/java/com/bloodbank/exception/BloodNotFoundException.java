package com.bloodbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BloodNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BloodNotFoundException(String msg) {
		super(msg);
	}
}
