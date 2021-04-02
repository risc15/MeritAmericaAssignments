package com.meritamerica.bankcapstone.models;

public class JwtRequest {
	
	private String userName;
	private String password;
	
	// Constructors:
	
	public JwtRequest() {
	}

	public JwtRequest(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	// Getters and setters:

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}