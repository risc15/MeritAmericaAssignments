package com.meritamerica.assignment7.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "AccountHolders")
public class AccountHolder implements Comparable<AccountHolder> {

	/*
	 * Constants:
	 */

	public static final long MAX_ALLOWED = 250000;

	/*
	 * Class Variables:
	 */

	// Mark as primary key:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accountId")
	long id;
	static int newId = 1;

	@NotBlank(message = "First name cannot be blank!")
	@Size(min = 2, max = 15, message = "First name must be at least 2 characters.")
	@Column
	private String firstName;

	@Column
	private String middleName;

	@NotBlank(message = "Last name cannot be blank!")
	@Size(min = 2, max = 20, message = "Last name must be at least 2 characters.")
	@Column
	private String lastName;

	@NotBlank(message = "SSN cannot be blank!")
	@Size(min = 9, max = 9, message = "SSN number must be 9 digits!")
	@Column
	private String ssn;

	@Column(name = "CheckingAccounts")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	public List<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();

	@Column(name = "SavingsAccounts")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	public List<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();

	@Column(name = "CDAccounts")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	public List<CDAccount> cdAccounts = new ArrayList<CDAccount>();

	/*
	 * Constructor:
	 */

	public AccountHolder() {
		
	}

	/*
	 * Class Methods:
	 */

//getters and setters

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSSN() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<CheckingAccount> getCheckingAccounts() {
		return checkingAccounts;
	}

	public void setCheckingAccount(List<CheckingAccount> checkingAccount) {
		checkingAccounts = checkingAccount;
	}

	public List<SavingsAccount> getSavingsAccounts() {
		return savingsAccounts;
	}

	public void setSavingsAccount(List<SavingsAccount> savingsAccount) {
		this.savingsAccounts = savingsAccount;
	}

//Goes through the account holder's savings accounts and returns the sum of them.

	public double getSavingsBalance() {
		double savingsBalance = 0;
		for (int i = 0; i < savingsAccounts.size(); i++) {
			System.out.println("Savings account number " + i + ": " + savingsAccounts.get(i).getBalance());
			savingsBalance += savingsAccounts.get(i).getBalance();
		}
		return savingsBalance;
	}

	public double getCheckingBalance() {
		double checkingBalance = 0;

		for (int i = 0; i < checkingAccounts.size(); i++) {
			checkingBalance = checkingBalance + checkingAccounts.get(i).getBalance();
		}
		return checkingBalance;
	}

	public List<CDAccount> getCDAccounts() {
		return cdAccounts;
	}

	public double getCDBalance() {

		double sum = 0;

		for (int i = 0; i < cdAccounts.size(); i++) {
			sum += cdAccounts.get(i).getBalance();
		}
		return sum;
	}

	public double getCombinedBalance() {
		double combinedBalance = 0;
		combinedBalance += getCheckingBalance();
		combinedBalance += getSavingsBalance();
		combinedBalance += getCDBalance();
		return combinedBalance;
	}

	public int getNumberOfCheckingAccounts() {
		return checkingAccounts.size();

	}

	public int getNumberOfSavingsAccounts() {
		return savingsAccounts.size();
	}

	public int getNumberOfCDAccounts() {
		return cdAccounts.size();
	}

	@Override
	public String toString() {
		return generateStringForToString();
	}

	private String generateStringForToString() {
		StringBuilder str = new StringBuilder();

		// append the name
		str.append("Name: " + getFirstName() + " " + getMiddleName() + " " + getLastName() + "\n");

		str.append("SSN: " + getSSN() + "\n");

		str.append(getCheckingAccounts().toString());

		// append savings account balance
		// append savings account interest rate
		// append the savings account balance in 3 years
		str.append(getSavingsAccounts().toString());

		// return the StringBuilder object as a string.
		return str.toString();
	}

	/*
	 * compareTo compares this account with another account. If this account's
	 * combined balance is greater than the other account, then it returns 1. If
	 * not, then it returns -1.
	 */
	@Override
	public int compareTo(AccountHolder otherAccountHolder) {
		if (this.getCombinedBalance() > otherAccountHolder.getCombinedBalance())
			return 1;
		else
			return -1;
	}

}