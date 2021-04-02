package com.meritamerica.bankcapstone.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;



// It is good practice to name the entity.
@Entity(name = "User")
public class User {

	// Class attributes:

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	@NotNull
	private String firstName;
	@Column
	@NotNull
	private String middleName;
	@Column
	@NotNull
	private String lastName;
	@Column
	@NotNull
	private String userName;
	@Column
	@NotNull
	private String password;
	@Column
	@NotNull
	private String email;
	@Column
	@NotNull
	private Date accountOpened = new Date();
	@Column
	@NotNull
	private Date dob;
	@Column
	@NotNull
	private int ssn;
	@Column
	@NotNull
	private boolean active = true;
	@Column
	@NotNull
	private String roles = "USER"; // Initialize to user since I only want one admin account.
	
	@OneToMany
	private List<CheckingAccount> checkingAccounts = new ArrayList<>(); // Can have multiple.
	@OneToMany
	private List<DBAAccount> dbaAccounts = new ArrayList<>(); // Can only have 3.
	@OneToMany
	private List<CDAccount> cdAccounts = new ArrayList<>(); // Can have multiple.
	@OneToMany
	private List<Transaction> transactions = new ArrayList<>();
	
	@OneToOne
	private SavingsAccount savingsAccounts; // Can only have one.
	@OneToOne
	private PersonalCheckingAccount personalCheckingAccount; // Can only have one.
	@OneToOne
	private RegularIRA regularIra;
	@OneToOne
	private RolloverIRA rolloverIra;
	@OneToOne
	private RothIRA rothIra;
	
	// Constructors:

	// JPA requires an empty constructor:
	public User() {

	}

	public User(String firstName, String middleName, String lastName, String userName, String email, Date dob, int ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.dob = dob;
		this.ssn = ssn;
	}

	// Getters and setters:

	public long getId() {
		return id;
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

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAccountOpened() {
		return accountOpened;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	// Checking Account methods: ===================================

	public List<CheckingAccount> getCheckingAccounts() {
		return checkingAccounts;
	}

	public void setCheckingAccounts(List<CheckingAccount> checkingAccounts) {
		this.checkingAccounts = checkingAccounts;
	}
	
	public void addCheckingAccount(CheckingAccount checkingAccount) {
		this.checkingAccounts.add(checkingAccount);
	}
	
	// Savings Account methods: ====================================

	public SavingsAccount getSavingsAccount() {
		return savingsAccounts;
	}

	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccounts = savingsAccount;
	}
	
	// Personal Checking Account methods: ==========================

	public PersonalCheckingAccount getPersonalCheckingAccount() {
		return personalCheckingAccount;
	}

	public void setPersonalCheckingAccount(PersonalCheckingAccount personalCheckingAccount) {
		this.personalCheckingAccount = personalCheckingAccount;
	}
	
	// DBA Account methods: ========================================

	public List<DBAAccount> getDbaAccounts() {
		return dbaAccounts;
	}

	public void setDbaAccounts(List<DBAAccount> dbaAccounts) {
		this.dbaAccounts = dbaAccounts;
	}
	
	public void addDbaAccount(DBAAccount dbaAccount) {
		this.dbaAccounts.add(dbaAccount);
	}
	
	// CD Account methods: =========================================

	public List<CDAccount> getCdAccounts() {
		return cdAccounts;
	}

	public void setCdAccounts(List<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
	}
	
	public void addCdAccount(CDAccount cdAccount) {
		this.cdAccounts.add(cdAccount);
	}
	
	// IR Account methods: =========================================

	public RegularIRA getRegularIra() {
		return regularIra;
	}

	public void setRegularIra(RegularIRA regularIra) {
		this.regularIra = regularIra;
	}

	public RolloverIRA getRolloverIra() {
		return rolloverIra;
	}

	public void setRolloverIra(RolloverIRA rolloverIra) {
		this.rolloverIra = rolloverIra;
	}

	public RothIRA getRothIra() {
		return rothIra;
	}

	public void setRothIra(RothIRA rothIra) {
		this.rothIra = rothIra;
	}
	
	// Transaction methods: ========================================
	
	public List<Transaction> getTransactions() {
		return this.transactions;
	}
	
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
	
	// Delete methods: =============================================
	
	public CheckingAccount deleteCheckingAccount(long id) {
		for(int i = 0; i < this.checkingAccounts.size(); i++) {
			if(checkingAccounts.get(i).getId() == id) {
				if(this.savingsAccounts == null) {
					this.setSavingsAccount(new SavingsAccount(0.0, 0.0));
					this.savingsAccounts.addBalance(this.checkingAccounts.get(i).getBalance());
				}else {
					this.savingsAccounts.addBalance(this.checkingAccounts.get(i).getBalance());
				}
				return this.checkingAccounts.remove(i);
			}
		}
		return null;
	}
	
	public void deleteSavingsAccount() {	
		this.savingsAccounts = null;
	}
	
	public void deletePersonalCheckingAccount() {
		if(this.savingsAccounts == null) {
			this.setSavingsAccount(new SavingsAccount(0.0, 0.0));
			this.savingsAccounts.addBalance(this.personalCheckingAccount.getBalance());
		}else {
			this.savingsAccounts.addBalance(this.personalCheckingAccount.getBalance());
		}
		this.personalCheckingAccount = null;
	}
	
	public DBAAccount deleteDbaAccount(long id) {
		for(int i = 0; i < this.dbaAccounts.size(); i++) {
			if(dbaAccounts.get(i).getId() == id) {
				if(this.savingsAccounts == null) {
					this.setSavingsAccount(new SavingsAccount(0.0, 0.0));
					this.savingsAccounts.addBalance(this.dbaAccounts.get(i).getBalance());
				} else {
					this.savingsAccounts.addBalance(this.dbaAccounts.get(i).getBalance());
				}
				return this.dbaAccounts.remove(i);
			}
		}
		return null;
	}
	
	public CDAccount deleteCdAccount(long id, String closingTo) {
		for(int i = 0; i < this.cdAccounts.size(); i++) {
			if(this.cdAccounts.get(i).getId() == id) {
				switch(closingTo) {
				case "Checking":
					if(this.personalCheckingAccount == null) {
						this.setPersonalCheckingAccount(new PersonalCheckingAccount(0.0, 0.0));
						this.personalCheckingAccount.addBalance(this.cdAccounts.get(i).getBalance());
					} else {
						this.personalCheckingAccount.addBalance(this.cdAccounts.get(i).getBalance());
					}
					break;
				case "Savings":
					if(this.savingsAccounts == null) {
						this.setSavingsAccount(new SavingsAccount(0.0, 0.0));
						this.savingsAccounts.addBalance(this.cdAccounts.get(i).getBalance());
					}else {
						this.savingsAccounts.addBalance(this.cdAccounts.get(i).getBalance());
					}
					break;
				default:
					break;
				}
			return this.cdAccounts.remove(i);
			}
		}
		return null;
	}
	
	public void deleteRegularIra(String closingTo) {
		switch(closingTo) {
		case "Checking":
			if(this.personalCheckingAccount == null) {
				this.setPersonalCheckingAccount(new PersonalCheckingAccount(0.0, 0.0));
				this.personalCheckingAccount.addBalance(this.regularIra.getBalance() * 0.8);
			} else {
				this.personalCheckingAccount.addBalance(this.regularIra.getBalance() * 0.8);
			}
			break;
		case "Savings":
			if(this.savingsAccounts == null) {
				this.setSavingsAccount(new SavingsAccount(0.0, 0.0));
				this.savingsAccounts.addBalance(this.regularIra.getBalance() * 0.8);
			} else {
				this.savingsAccounts.addBalance(this.regularIra.getBalance() * 0.8);
			}
			break;
		default:
			break;
		}
		this.regularIra = null;
	}
	
	public void deleteRolloverIra(String closingTo) {
		switch(closingTo) {
		case "Checking":
			if(this.personalCheckingAccount == null) {
				this.setPersonalCheckingAccount(new PersonalCheckingAccount(0.0, 0.0));
				this.personalCheckingAccount.addBalance(this.rolloverIra.getBalance() * 0.8);
			} else {
				this.personalCheckingAccount.addBalance(this.rolloverIra.getBalance() * 0.8);
			}
			break;
		case "Savings":
			if(this.savingsAccounts == null) {
				this.setSavingsAccount(new SavingsAccount(0.0, 0.0));
				this.savingsAccounts.addBalance(this.rolloverIra.getBalance() * 0.8);
			} else {
				this.savingsAccounts.addBalance(this.rolloverIra.getBalance() * 0.8);
			}
			break;
		default:
			break;
		}
		this.rolloverIra = null;
	}
	
	public void deleteRothIra(String closingTo) {
		switch(closingTo) {
		case "Checking":
			if(this.personalCheckingAccount == null) {
				this.setPersonalCheckingAccount(new PersonalCheckingAccount(0.0, 0.0));
				this.personalCheckingAccount.addBalance(this.rothIra.getBalance() * 0.8);
			} else {
				this.personalCheckingAccount.addBalance(this.rothIra.getBalance() * 0.8);
			}
			break;
		case "Savings":
			if(this.savingsAccounts == null) {
				this.setSavingsAccount(new SavingsAccount(0.0, 0.0));
				this.savingsAccounts.addBalance(this.rothIra.getBalance() * 0.8);
			} else {
				this.savingsAccounts.addBalance(this.rothIra.getBalance() * 0.8);
			}
			break;
		default:
			break;
		}
		this.rothIra = null;
	}
	
	// Hashcode, toString, and equals methods:
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", userName=" + userName + ", email=" + email + ", accountOpened=" + accountOpened + ", dob=" + dob
				+ ", ssn=" + ssn + ", active=" + active + "]";
	}

	

}