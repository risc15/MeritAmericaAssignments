package com.meritamerica.bankcapstone.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CDOffering {
	
	// Class attributes:

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int term;
	private double interestRate;
	
	// Constructors:
	
	public CDOffering() {
		
	}
	
	public CDOffering(int term, double interestRate) {
		this.term = term;
		this.interestRate = interestRate;
	}
	
	// Getters and setters:

	public long getId() {
		return id;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	// Class methods:

}
