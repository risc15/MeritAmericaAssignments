package com.meritamerica.assignment7.models;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class CDOffering {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull(message = "Missing term.")
	@Min(value = 1, message = "Term should be greater than 0.")
	private static int term;
	@NotNull(message = "Missing interestRate.")
	private double interestRate;

	public CDOffering() {

	}

	public long getID() {
		return id;
	}

	public void setID(long id) {
		this.id = id;
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

}