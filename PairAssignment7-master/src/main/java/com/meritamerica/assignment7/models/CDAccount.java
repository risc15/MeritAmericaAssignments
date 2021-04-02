package com.meritamerica.assignment7.models;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@DiscriminatorValue("CD")
public class CDAccount extends BankAccount {

	static private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private int term;

	public CDAccount() {
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public Date getStartDate() {
		Date date = new Date();
		return date;
	}

	@Override
	public boolean deposit(double amount) {
		return false;
	}

	@Override
	public boolean withdraw(double amount) {
		return false;
	}

}