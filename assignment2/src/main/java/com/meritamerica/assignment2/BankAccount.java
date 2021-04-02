package com.meritamerica.assignment2;

public class BankAccount {
	
	/*
	 * Instance Variables:
	 */
	
	private double accountBalance;
//	private long masterAccountNumber = 000000000;
	private long accountNumber = 000000000;
	private double interestRate;
	
	/*
	 * Constructors:
	 */
	
	public BankAccount(double balance) {
		this.accountBalance = balance;
		this.accountNumber = AccountHolder.getNewAccountNumber();
	}
	
	public BankAccount(double balance, double interestRate) {
		this.accountBalance = balance;
		this.interestRate = interestRate;
		this.accountNumber = AccountHolder.getNewAccountNumber();
	}
	
	public BankAccount(long accountNumber, double balance, double interestRate) {
		this.accountNumber = accountNumber;
		this.accountBalance = balance;
		this.accountNumber = accountNumber;
		this.accountNumber = AccountHolder.getNewAccountNumber();
	}
	
	/*
	 * Class methods:
	 */
	
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		
		return this.accountBalance;
	}
	
	public boolean withdraw(double amount) {
		if(amount <= this.accountBalance) {
			this.accountBalance -= amount;
			return true;
		} else {
			System.out.println("You have insufficient funds to complete this transaction. " +
								"Please call your bank if you feel this information is incorrect.");
			return false;
		}
	}
	
	public boolean deposit(double amount) {
		if(amount <= 0) {
			System.out.println("Cannot add a value of $0 or less!");
			return false;
		} else {
			this.accountBalance += amount;
			System.out.println("Deposited $" + amount + " into your account.");
			return true;
		}
	}
	
}
