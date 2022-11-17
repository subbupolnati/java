package com.security.model;

public class JwtResponse {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + "]";
	}

	public JwtResponse(String token) {
		super();
		this.token = token;
	}

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
