package com.meritamerica.assignment2;

import java.util.Date;

public class CDAccount extends BankAccount{
	
	/*
	 * Instance Variables:
	 */
	
	private CDOffering offering;
	private Date startDate;
	
	/*
	 * Constructor:
	 */
	
	CDAccount(CDOffering offering, double balance) {
		super(balance);
		this.offering = offering;
	}
	
	/*
	 * Methods:
	 */

	double getInterestRate() {
		return this.offering.getInterestRate();
	}
	int getTerm() {
		return this.offering.getTerm();
	}
	java.util.Date getStartDate() {
		return startDate;
	}

	public double futureValue(int years) {
		return this.getBalance() * (Math.pow(1 + this.getInterestRate(), years));
	}

}