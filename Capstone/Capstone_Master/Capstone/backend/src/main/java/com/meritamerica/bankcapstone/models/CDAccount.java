/*
 * CDAccount - Certificate of Deposit
 */

package com.meritamerica.bankcapstone.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("CD")
public class CDAccount extends BankAccount {
	
	// Class attributes:
	@OneToOne
	private CDOffering cdOffering;
	
	@Column
	private int term;
	
	// Constructors:

	public CDAccount() {
	}
	
	// Getters and setters:
	
	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}
	
	public CDOffering getCDOffering() {
		return this.cdOffering;
	}
	
	public void setCDOffering(CDOffering cdOffering) {
		this.cdOffering = cdOffering;
	}
	// Class methods:

}
