package com.inventorymanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PermissionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PermissionNotFoundException(String msg) {
		super(msg);
	}
}
