package com.meritamerica.assignment2;

public class AccountHolder {
	
	/*
	 * Constants:
	 */
	
	public static final long MAX_ALLOWED = 250000;
	
	/*
	 * Instance variables:
	 */
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	private CheckingAccount[] checkAccounts = new CheckingAccount[0];
	private SavingsAccount[] saveAccounts = new SavingsAccount[0];
	private CDAccount[] cdAccounts = new CDAccount[0];
	private static long masterAccountNumber;
	
	/*
	 * Constructors:
	 */
	
	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		masterAccountNumber = 000000000;
	}
	
	/*
	 * Class Methods:
	 */
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
	
	public String getSSN() {
		
		return this.ssn;
	}
	
	private void setSSN(String ssn) {
		
		this.ssn = ssn;
	}

	/*
	 * addCheckingAccount
	 * 
	 * These two methods add a checking account to the checkingAccount class array.
	 * One accepts an opening balance and creates a new checking account object.
	 * Then, if the combined balance of all accounts is less than 250000, we call
	 * the other addCheckingAccount method and pass it our new checking account.
	 * 
	 * In the second method, we create a new array equal with a size equal to the
	 * old checking account array plus one. Loop through and re-add old objects,
	 * then add our newest one.
	 * 
	 * Finally, we set the old checking account array equal to the new one. This
	 * essentially updates the pointer in the checkAccounts array.
	 */
	public CheckingAccount addCheckingAccount(double openingBalance) {
		CheckingAccount newname = new CheckingAccount(openingBalance);
		
		if(getCombinedBalance() + openingBalance >= MAX_ALLOWED) {
			System.out.println("You have reached the maximum total balance across all accounts. Cannot create another.");
			return null;
		} else {
		return addCheckingAccount(newname);
		}
		
	}

	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		if(getCombinedBalance() + checkingAccount.getBalance() >= MAX_ALLOWED) {
			System.out.println("You have reached the maximum total balance across all accounts. Cannot create another.");
			return null;
		} else {
			CheckingAccount[] newArray = new CheckingAccount[checkAccounts.length + 1];
			int i;
			for (i = 0; i < checkAccounts.length; i++) {
				newArray[i] = checkAccounts[i];
			}
		
			newArray[i] = checkingAccount;
			checkAccounts = newArray;
		
			return checkingAccount;
		}
	}
	
	/*
	 * getCheckingAccounts
	 * 
	 * This method returns the checkAccounts array.
	 */
	public CheckingAccount[] getCheckingAccounts() {
		return checkAccounts;
	}
	
	/*
	 * getNumberOfCheckingAccounts
	 * 
	 * Simply returns how many checking accounts we have.
	 */
	public int getNumberOfCheckingAccounts() {
		return this.checkAccounts.length;
	}
	
	/*
	 * getCheckingBalance
	 * 
	 * This method returns a total of all the checking accounts
	 * combined.
	 */
	public double getCheckingBalance() {
		double total = 0;
		for(int i = 0;i < checkAccounts.length; i++) {
			total += checkAccounts[i].getBalance();
		}
		
		return total;
	}
	
	
	public SavingsAccount addSavingsAccount(double openingBalance) {
		SavingsAccount newname = new SavingsAccount(openingBalance);
		
		if(getCombinedBalance() + openingBalance >= MAX_ALLOWED) {
			System.out.println("You have reached the maximum total balance across all accounts. Cannot create another.");
			return null;
		} else {
			return addSavingsAccount(newname);
		}
	}

	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		if(getCombinedBalance() + savingsAccount.getBalance() >= MAX_ALLOWED) {
			System.out.println("You have reached the maximum total balance across all accounts. Cannot create another.");
			return null;
		} else {
			SavingsAccount[] newArray = new SavingsAccount[saveAccounts.length + 1];
			int i;
			for (i = 0; i < saveAccounts.length; i++) {
				newArray[i] = saveAccounts[i];
			}
			newArray[i] = savingsAccount;
			saveAccounts = newArray;
			return savingsAccount;
		}
	}

	public SavingsAccount[] getSavingsAccounts() {
		return this.saveAccounts;
	}

	public int getNumberOfSavingsAccounts() {
		return this.saveAccounts.length;
	}

	public double getSavingsBalance() {
		double total = 0;
		
		for(int i = 0;i < saveAccounts.length;i++) {
			total += saveAccounts[i].getBalance();
		}
		
		return total;
	}
	
	public CDAccount addCDAccount(CDAccount cdAccount) {
		CDAccount[] newArray = new CDAccount[cdAccounts.length + 1];
		int i;
		for (i = 0; i < cdAccounts.length; i++) {
			newArray[i] = cdAccounts[i];
		}
		newArray[i] = cdAccount;
		cdAccounts = newArray;
		return cdAccount;
	}

	public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		CDAccount newName = new CDAccount(offering, openingBalance);
		return addCDAccount(newName);
	}

	public CDAccount[] getCDAccounts() {
		return this.cdAccounts;
	}

	public int getNumberOfCDAccounts() {
		return this.cdAccounts.length;
	}

	public double getCDBalance() {
		double total = 0;
		
		for(int i = 0;i < cdAccounts.length;i++) {
			total += cdAccounts[i].getBalance();
		}
		
		return total;
	}

	public double getCombinedBalance() {
		double total = 0;
		
		for(int i = 0;i < checkAccounts.length;i++) {
			total += checkAccounts[i].getBalance();
		}
		
		for(int i = 0;i < saveAccounts.length;i++) {
			total += saveAccounts[i].getBalance();
		}
		
		for(int i = 0;i < cdAccounts.length;i++) {
			total += cdAccounts[i].getBalance();
		}
		
		return total;
	}
	
	public String toString() {
		return "Name: " + this.firstName + " " + this.middleName + " " + this.lastName + "\n" +
				"SSN: " + this.ssn + "\n" +
				this.getCheckingAccounts().toString();
	}
	
	public static long getNewAccountNumber() {
		
		return masterAccountNumber + 1;
	}
	
}