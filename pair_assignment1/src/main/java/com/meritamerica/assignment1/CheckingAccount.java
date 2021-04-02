package com.meritamerica.assignment1;

public class CheckingAccount {
	
	double balance;				// balance will be returned with the balance of each AccountHolder, as seen with getBalance()
	public CheckingAccount(double balance) {
		
		this.balance = balance;
	}
	public double getBalance() {
		
		return this.balance;
	}
	public double getInterestRate() {
		
		return 0.0001;
	}
	public boolean withdraw(double amount) {	// Funds cannot be taken out if the amount being withdrawn is greater than the balance
		
		if (amount > getBalance()) {
			
			System.out.println("You have insufficient funds to complete this transaction. "
							 + "Please call your bank if you feel this information is incorrect.");
			return false;
		} else {
			
			this.balance -= amount;
			return true;
		}
	}
	public boolean deposit(double amount) {		// Can't add anything to your account that's less than or equal to 0.
		
		if (amount <= 0) {
			
			System.out.println("Cannot add a value of $0 or less!");
			return false;
		} else {
			
			this.balance += amount;
			return true;
		}
	}
	public double truncateValue(double toTruncate) {		// Optionally truncates the output of the account balance in 3 years.
		
		toTruncate *= 100; 
		int truncatedInt = (int)toTruncate;
		double truncatedDouble = (double)truncatedInt / 100;
		return truncatedDouble;
	}
	public double futureValue(int years) {		// Calculates how much interest you earn in 'years' years (in this case, 3)
		
		return this.getBalance() * (Math.pow(1 + this.getInterestRate(), years));
	}
	public String toString() {
		
		return  "Checking Account Balance: $" + this.getBalance() + "\n" +
				"Checking Account Interest Rate: 0.0001\n" +
				"Checking Account Balance in 3 years: $" + this.truncateValue(futureValue(3));
	}
}