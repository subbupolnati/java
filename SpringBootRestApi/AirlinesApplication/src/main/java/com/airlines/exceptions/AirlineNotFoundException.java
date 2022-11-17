package com.airlines.exceptions;

public class AirlineNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AirlineNotFoundException(String msg) {
		super(msg);
	}

}
