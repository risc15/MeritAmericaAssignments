package com.meritamerica.assignment7.models;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.*;

import org.hibernate.annotations.DiscriminatorOptions;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorOptions(force = true)
public abstract class BankAccount {
	static int nextID = 0;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long accountNumber;
	@Column
	public double interestRate = 0;
	@Column
	private double balance = 0;
	@Column
	private static java.util.Date accountOpenedOn;

	@ManyToOne
	@JoinColumn(name = "account_holder_id")
	@JsonIgnore
	protected AccountHolder accountHolder;

	static private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		private List<Transaction> transactions = new ArrayList<Transaction>();

	public BankAccount() {
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder acct) {
		this.accountHolder = acct;
	}

	public java.util.Date accountOpenedOn() {

		return accountOpenedOn;
	}

	public java.util.Date getOpenedOn() {

		return accountOpenedOn;
	}

	public boolean withdraw(double amount) {
		if (amount < 0) {
			System.out.println("You may not withdraw a negative amount.");
			return false;
		}

		if (amount > getBalance()) {
			System.out.println("amount: " + amount + ". getBalance: " + getBalance());
			System.out.println("There is not enough money in the checking account to make this withdrawal");
			return false;
		}
		balance = getBalance() - amount;
		return true;
	}

	public boolean deposit(double amount) {
		if (amount < 0) {
			System.out.println("You may not deposit a negative amount.");
			return false;
		}
		balance = getBalance() + amount;
		return true;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(double interest) {
		this.interestRate = interest;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountNumber() {
		return this.accountNumber;
	}

	/*
	 * returns the specified decimal formatted in United States Dollar
	 */
	public static String displayInUSD(double decimal) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

		return formatter.format(decimal);
	}

	public static java.util.Date getAccountOpenedOn() {
		return accountOpenedOn;
	}

	public static void setAccountOpenedOn(java.util.Date accountOpenedOn) {
		BankAccount.accountOpenedOn = accountOpenedOn;
	}
	/*
	 * public void addTransaction(Transaction transaction) {
	 * transactions.add(transaction); }
	 * 
	 * public List<Transaction> getTransactions() { return transactions; }
	 */
}