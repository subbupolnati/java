package com.bloodbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -148696313785689331L;

	public PatientNotFoundException(String msg) {
		super(msg);
	}
}
