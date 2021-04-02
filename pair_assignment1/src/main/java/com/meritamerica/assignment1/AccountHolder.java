package com.meritamerica.assignment1;
public class AccountHolder {		// For sake of clarity, each AccountHolder will have 6 parameters.
									// Some are private, like the social security number.
	public String firstName;
	public String middleName;
	public String lastName;
	private String ssn;
	double checkingAccountOpeningBalance;
	double savingsAccountOpeningBalance;
	CheckingAccount checkAccount;
	SavingsAccount saveAccount;
	public AccountHolder(String firstName, String middleName, String lastName, String ssn, 
						double checkingAccountOpeningBalance, double savingsAccountOpeningBalance) {
		
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.checkingAccountOpeningBalance = checkingAccountOpeningBalance;
		this.savingsAccountOpeningBalance = savingsAccountOpeningBalance;
		checkAccount = new CheckingAccount(checkingAccountOpeningBalance);
		saveAccount = new SavingsAccount(savingsAccountOpeningBalance);
	}
	public String getFirstName() {
		
		return this.firstName;
	}
	private void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}
	public String getMiddleName() {
		
		return this.middleName;
	}
	private void setMiddleName(String middleName) {
		
		this.middleName = middleName;
	}
	public String getLastName() {
		
		return this.lastName;
	}
	private void setLastName(String lastName) {
		
		this.lastName = lastName;
	}
	private String getSSN() {
		
		return this.ssn;
	}
	private void setSSN(String ssn) {
		
		this.ssn = ssn;
	}
	public CheckingAccount getCheckingAccount() {
		
		return this.checkAccount;
	}
	public SavingsAccount getSavingsAccount() {
		
		return this.saveAccount;
	}
	public String toString() {
		return "Name: " + this.firstName + " " + this.middleName + " " + this.lastName + "\n" +
				"SSN: " + this.ssn + "\n" +
				this.getCheckingAccount().toString() + "\n" +
				this.getSavingsAccount().toString();
	}
}