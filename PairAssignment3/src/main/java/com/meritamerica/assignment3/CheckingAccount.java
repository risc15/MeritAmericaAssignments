package com.meritamerica.assignment3;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Date;
import java.text.SimpleDateFormat;



public class CheckingAccount extends BankAccount {

	/*
	 * Class variables:
	 */
	
	static private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	/*
	 * Constructors:
	 */

	public CheckingAccount(double balance) {
		super(balance);
		this.interestRate = 0.0001;
	}
	
	public CheckingAccount(double balance, double interestRate) {
		super(balance,interestRate);
	}
	
	public CheckingAccount(long accountNumber, double balance, double interestRate) {
		super(accountNumber,balance,accountNumber);
	}
	
	public CheckingAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
		super(accountNumber,balance,interestRate,accountOpenedOn);
	}

	/*
	 * Class methods:
	 */

	public double getInterestRate() {
		return this.interestRate;
	}

	public static CheckingAccount readFromString(String accountData) throws ParseException {
		try {
			//String[] newAccountHolder = accountData.split(",");
			ArrayList<String> newAccountHolder = new ArrayList<String>(Arrays.asList(accountData.split(",")));

			return new CheckingAccount(Long.parseLong(newAccountHolder.get(0)),
				Double.parseDouble(newAccountHolder.get(1)),
				Double.parseDouble(newAccountHolder.get(2)),
				formatter.parse(newAccountHolder.get(3)));
		} catch (ParseException e) {
			//throw new java.lang.NumberFormatException();
			return null;
		}
	}
	
	

}