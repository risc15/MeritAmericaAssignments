package com.meritamerica.bankcapstone.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Savings")
public class SavingsAccount extends BankAccount {
	public SavingsAccount() {
		
	}
	
	public SavingsAccount(double balance, double interestRate) {
		this.setBalance(balance);
		this.setInterestRate(interestRate);
	}
}
