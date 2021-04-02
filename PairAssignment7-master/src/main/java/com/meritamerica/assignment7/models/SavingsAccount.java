package com.meritamerica.assignment7.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Savings")
public class SavingsAccount extends BankAccount {

	static private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public SavingsAccount() {

	}

}