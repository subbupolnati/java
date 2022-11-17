package com.inventorymanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InventoryNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public InventoryNotFoundException(String msg) {
		super(msg);
	}

}
