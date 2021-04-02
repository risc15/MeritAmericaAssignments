package com.meritamerica.assignment1;

public class SavingsAccount {
	
	/*
	 * Instance Variables:
	 */
	
	private double accountBalance;
	private double interestRate;

	/*
	 * Constructor:
	 */
	
	public SavingsAccount(double openingBalance) {
		this.accountBalance = openingBalance;
		this.interestRate = 0.01;
		System.out.println("New savings account created.");
	}
	
	/*
	 * Methods:
	 */
	
	public double getBalance() {
		return this.accountBalance;
	}
	
	/*
	 * getInterestRate
	 * 
	 * Returns the interest rate.
	 */
	public double getInterestRate() {
		return interestRate;
	}
	
	/*
	 * withdraw
	 * 
	 * Withdraws money from the account. Will return false if the amount withdrew is zero or less.
	 */
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
	
	/*
	 * deposit
	 * 
	 * Deposits money into the account. Will return false if the amount deposited is zero or less.
	 */
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
	
	/*
	 * futureValue
	 * 
	 * This computes how much money an account will have in a vaiable amount of
	 * years.
	 */
	public double futureValue(int years) {
		return this.accountBalance * (Math.pow(1 + this.interestRate, years));
	}
	
	/*
	 * truncate
	 * 
	 * This will truncate a double to the hundredth's place. Good for displaying
	 * money.
	 */
	private double truncate(double valueToTruncate) {
		int newValue = (int)valueToTruncate * 100;
		return valueToTruncate = newValue / 100;
	}
	
	public String toString() {
		return "Savings Account Balance: $" + this.accountBalance + "\n" +
				"Savings Account Interest Rate: " + this.interestRate + "\n" +
				"Savings Account Balance in 3 years: $" + this.truncate(this.futureValue(3));
	}
	
}