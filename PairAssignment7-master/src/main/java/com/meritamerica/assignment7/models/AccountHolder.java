package com.meritamerica.assignment7.models;

import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.meritamerica.assignment7.exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment7.exceptions.ExceedsFraudSuspicionLimitException;

@Entity
@Table(name = "AccountHolders")
public class AccountHolder implements Comparable<AccountHolder> {
	public static final long MAX_ALLOWED = 250000;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	static long newId = 1;
	
	@Column(name = "firstName")
	@NotBlank(message = "Need first name")
	private String firstName;
	
	@Column(name = "middleName")
	private String middleName;
	
	@Column(name = "lastName")
	@NotBlank(message = "Need last name")
	private String lastName;
	
	@Column(name = "ssn")
	@NotBlank(message = "Need ssn")
	private String ssn;
	
	@Column(name = "combinedBalance")
	private double combinedBalance = 0;

	@Column(name = "checkingAccounts")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	public List<CheckingAccount> checkingAccounts = new ArrayList<>();

	@Column(name = "savingsAccounts")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	public List<SavingsAccount> savingsAccounts = new ArrayList<>();

	@Column(name = "cdAccounts")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountHolder")
	public List<CDAccount> cdAccounts = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_contact_id", referencedColumnName = "account_contact_id")
	AccountContact accountContact;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "useraccount_id")
	private User user;

	public AccountHolder() {
	}

// getters and setters
	
	@JsonManagedReference(value = "users")
	public User getUser() {
		return user;
	}

	public AccountContact getAccountContact() {
		return accountContact;
	}

	public void setAccountContact(AccountContact accountContact) {
		this.accountContact = accountContact;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

// Goes through the account holder's savings accounts and returns the sum of them.

	public double getSavingsBalance() {
		double savingsBalance = 0;
		for (int i = 0; i < savingsAccounts.size(); i++) {
			System.out.println("Savings account number " + i + ": " + savingsAccounts.get(i).getBalance());
			savingsBalance += savingsAccounts.get(i).getBalance();
		}
		return savingsBalance;
	}

	/*
	 * Makes a checking account with an opening balance as the argument. Returns the
	 * addCheckingAccount() method with the newly made account as an argument.
	 */

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
		this.combinedBalance = combinedBalance;
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

	public List<CheckingAccount> getCheckingAccounts() {
		return checkingAccounts;
	}

	public List<SavingsAccount> getSavingsAccounts() {
		return savingsAccounts;
	}

}