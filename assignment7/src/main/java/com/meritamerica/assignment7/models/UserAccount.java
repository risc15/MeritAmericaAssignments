package com.meritamerica.assignment7.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String username;
	@Column
	private String password;
	private AccountHolder accountHolder;
	
	// Constructors:
	
	public UserAccount(long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public UserAccount() {
		
	}
	
	// Getters:

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}
	
	// Setters:

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
}
