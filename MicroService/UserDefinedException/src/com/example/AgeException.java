package com.example;

public class AgeException extends RuntimeException {

	String msg;
	public AgeException(String msg) {
		this.msg=msg;
		System.out.println(msg);
	}
}
