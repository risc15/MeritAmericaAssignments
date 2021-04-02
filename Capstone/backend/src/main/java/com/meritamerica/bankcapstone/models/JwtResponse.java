package com.meritamerica.bankcapstone.models;

public class JwtResponse {
	
	// Attributes:
	
	private String jwtToken;
	
	// Constructors:
	
	public JwtResponse() {
	}

	public JwtResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	// Getters and setters:

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	
}