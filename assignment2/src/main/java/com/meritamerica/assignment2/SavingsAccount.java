package com.meritamerica.assignment2;

public class SavingsAccount extends BankAccount {
	


	/*
	 * Instance Variables:
	 */

	/*
	 * Constructor:
	 */
	
	public SavingsAccount(double balance) {
		super(balance);
	}

	

	/*
	 * Methods:
	 */
	
	public double getInterestRate() {
		return 0.01;
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
	
	public double futureValue(int years) {
		return this.getBalance() * (Math.pow(1 + this.getInterestRate(), years));
	}
	
	public String toString() {
		return "Savings Account Balance: $" + this.getBalance() + "\n" +
				"Savings Account Interest Rate: 0.01\n" +
				"Savings Account Balance in 3 years: $" + this.truncate(this.futureValue(3));
	}
	
}