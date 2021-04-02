/*
 * DBA - Doing Business As
 * 
 */

package com.meritamerica.bankcapstone.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DBA")
public class DBAAccount extends BankAccount {
	
	public DBAAccount() {
		
	}

}
