package com.college.exceptions;

public class FacultyNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FacultyNotFoundException(String msg) {
		super(msg);
	}

}
