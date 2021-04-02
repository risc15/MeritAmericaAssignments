/*
 * Transaction
 * 
 * This class is primarily for logging. It will be added to a list of transactions in a database
 * that shows all deposits and withdrawals to and from accounts.
 * 
 */

package com.meritamerica.bankcapstone.models;

import javax.persistence.Entity;

public class Transaction {
	
	// Class attributes:
	
	private long id;
	private User targetAccount;
	private User sourceAccount;
	private double amount;
	private String type; 		// Check, cash, ATM, or transfer?
	
	// Constructors:
	
	public Transaction() {
		
	}

	public Transaction(User targetAccount, User sourceAccount, double amount, String type) {
		this.targetAccount = targetAccount;
		this.sourceAccount = sourceAccount;
		this.amount = amount;
		this.type = type;
	}
	
	// Getters and setters:

	public long getId() {
		return id;
	}

	public User getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(User targetAccount) {
		this.targetAccount = targetAccount;
	}

	public User getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(User sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	// Class methods:
	
}
