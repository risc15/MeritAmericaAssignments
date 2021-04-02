package com.meritamerica.bankcapstone.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Checking")
public class CheckingAccount extends BankAccount {
	
	public CheckingAccount() {
		
	}

}
