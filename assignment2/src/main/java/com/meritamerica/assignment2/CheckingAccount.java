package com.meritamerica.assignment2;

public class CheckingAccount extends BankAccount{
	

	/*
	 * Instance variables:
	 */	
	
	/*
	 * Constructors:
	 */
	
	public CheckingAccount(double balance) {
		super(balance);
	}

	/*
	 * Class methods:
	 */
	
	public double getInterestRate() {
		return 0.0001;
	}
	
	public double truncateValue(double toTruncate) {		// Optionally truncates the output of the account balance in 3 years.
		
		toTruncate *= 100; 
		int truncatedInt = (int)toTruncate;
		double truncatedDouble = (double)truncatedInt / 100;
		return truncatedDouble;
	}
	
	public double futureValue(int years) {
		return getBalance() * (Math.pow(1 + getInterestRate(), years));
	}
	
	public String toString() {
		
		return  "Checking Account Balance: $" + getBalance() + "\n" +
				"Checking Account Interest Rate: 0.0001\n" +
				"Checking Account Balance in 3 years: $" + truncateValue(futureValue(3));
	}
}