package com.airlinesproducer.exceptions;
//This class raise AirlineNotFound Exception 
public class AirlineNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AirlineNotFoundException(String msg) {
		super(msg);
	}

}
