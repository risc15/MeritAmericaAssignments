package com.meritamerica.bankcapstone.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private boolean active;

	// If sets don't work, use lists instead:
	
	@OneToMany
	private List<CheckingAccount> checkingAccounts = new ArrayList<>(); // Can have multiple.
	@OneToOne
	private SavingsAccount savingsAccounts; // Can only have one.
	@OneToOne
	private PersonalCheckingAccount personalCheckingAccount; // Can only have one.
	@OneToMany
	private List<DBAAccount> dbaAccounts = new ArrayList<>(); // Can only have 3.
	@OneToMany
	private List<CDAccount> cdAccounts = new ArrayList<>(); // Can have multiple.
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
	
	// Hashcode, toString, and equals methods:

	public List<CheckingAccount> getCheckingAccounts() {
		return checkingAccounts;
	}

	public void setCheckingAccounts(List<CheckingAccount> checkingAccounts) {
		this.checkingAccounts = checkingAccounts;
	}
	
	public void addCheckingAccount(CheckingAccount checkingAccount) {
		this.checkingAccounts.add(checkingAccount);
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccounts;
	}

	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccounts = savingsAccount;
	}

	public PersonalCheckingAccount getPersonalCheckingAccount() {
		return personalCheckingAccount;
	}

	public void setPersonalCheckingAccount(PersonalCheckingAccount personalCheckingAccount) {
		this.personalCheckingAccount = personalCheckingAccount;
	}

	public List<DBAAccount> getDbaAccounts() {
		return dbaAccounts;
	}

	public void setDbaAccounts(List<DBAAccount> dbaAccounts) {
		this.dbaAccounts = dbaAccounts;
	}
	
	public void addDbaAccount(DBAAccount dbaAccount) {
		this.dbaAccounts.add(dbaAccount);
	}

	public List<CDAccount> getCdAccounts() {
		return cdAccounts;
	}

	public void setCdAccounts(List<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
	}
	
	public void addCdAccount(CDAccount cdAccount) {
		this.cdAccounts.add(cdAccount);
	}

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

	public CheckingAccount deleteCheckingAccount(long id) {
		for(int i = 0; i < this.checkingAccounts.size(); i++) {
			if(checkingAccounts.get(i).getId() == id) {
				return this.checkingAccounts.remove(i);
			}
		}
		return null;
	}
	
	public void deleteSavingsAccount() {
		this.savingsAccounts = null;
	}
	
	public void deletePersonalCheckingAccount() {
		this.personalCheckingAccount = null;
	}
	
	public void deleteDbaAccount(long id) {
		for(int i = 0; i < this.dbaAccounts.size(); i++) {
			if(dbaAccounts.get(i).getId() == id) {
				dbaAccounts.remove(i);
				return;
			}
		}
		return;
	}
	
	public void deleteCdAccount(long id) {
		for(int i = 0; i < this.cdAccounts.size(); i++) {
			if(cdAccounts.get(i).getId() == id) {
				cdAccounts.remove(i);
				return;
			}
		}
		return;
	}
	
	public void deleteRegularIra() {
		this.regularIra = null;
	}
	
	public void deleteRolloverIra() {
		this.rolloverIra = null;
	}
	
	public void deleteRothIra() {
		this.rothIra = null;
	}
	
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
