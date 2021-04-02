package com.meritamerica.bankcapstone.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Personal Checking")
public class PersonalCheckingAccount extends BankAccount {
	
	public PersonalCheckingAccount() {
		
	}
	
	public PersonalCheckingAccount(double interestRate, double balance) {
		this.setBalance(balance);
		this.setInterestRate(interestRate);
	}
}
