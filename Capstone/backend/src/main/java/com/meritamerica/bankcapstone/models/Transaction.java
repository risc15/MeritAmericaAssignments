package com.meritamerica.bankcapstone.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	// Class attributes:
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String user;
	private long accountId;
	private String accountType; 	// CD, Checking, DBA, PersonalChecking, RegularIRA, RothIra, RolloverIRA, Savings
	private double amount;
	private String type; 			// Check, cash, ATM, or transfer?
	private boolean isProcessed;	// Whether or not it was successfully processed.
	Date transactionDate = new Date();
	
	// Constructors:
	
	public Transaction() {
		
	}
	
	public Transaction(String user,long accountId, String accountType, double amount, String type) {
		this.user = user;
		this.accountId = accountId;
		this.accountType = accountType;
		this.amount = amount;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public String getSourceUser() {
		return user;
	}

	public void setSourceUser(String sourceUser) {
		this.user = sourceUser;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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

	public String getFromUser() {
		return user;
	}

	public void setFromUser(String fromUser) {
		this.user = fromUser;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
}