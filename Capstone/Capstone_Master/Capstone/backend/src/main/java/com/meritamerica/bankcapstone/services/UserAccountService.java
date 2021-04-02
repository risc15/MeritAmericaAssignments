package com.meritamerica.bankcapstone.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.meritamerica.bankcapstone.models.CDAccount;
import com.meritamerica.bankcapstone.models.CDOffering;
import com.meritamerica.bankcapstone.models.CheckingAccount;
import com.meritamerica.bankcapstone.models.DBAAccount;
import com.meritamerica.bankcapstone.models.PersonalCheckingAccount;
import com.meritamerica.bankcapstone.models.RegularIRA;
import com.meritamerica.bankcapstone.models.RolloverIRA;
import com.meritamerica.bankcapstone.models.RothIRA;
import com.meritamerica.bankcapstone.models.SavingsAccount;
import com.meritamerica.bankcapstone.models.Transaction;
import com.meritamerica.bankcapstone.models.User;
import com.meritamerica.bankcapstone.repositories.CDAccountRepository;
import com.meritamerica.bankcapstone.repositories.CDOfferingRepository;
import com.meritamerica.bankcapstone.repositories.CheckingAccountRepository;
import com.meritamerica.bankcapstone.repositories.DBARepository;
import com.meritamerica.bankcapstone.repositories.PersonalCheckingAccountRepository;
import com.meritamerica.bankcapstone.repositories.RegularIRARepository;
import com.meritamerica.bankcapstone.repositories.RolloverIRARepository;
import com.meritamerica.bankcapstone.repositories.RothIRARepository;
import com.meritamerica.bankcapstone.repositories.SavingsAccountRepository;
import com.meritamerica.bankcapstone.repositories.TransactionRepository;
import com.meritamerica.bankcapstone.repositories.UserRepository;

@Service
public class UserAccountService {

	// Repositories:

	@Autowired
	UserRepository userRepository;

	@Autowired
	SavingsAccountRepository savingsAccountRepository;

	@Autowired
	RothIRARepository rothIRARepository;

	@Autowired
	RolloverIRARepository rolloverIRARepository;

	@Autowired
	RegularIRARepository regularIRARepository;

	@Autowired
	PersonalCheckingAccountRepository personalCheckingAccountRepository;

	@Autowired
	DBARepository dbaRepository;

	@Autowired
	CheckingAccountRepository checkingAccountRepository;

	@Autowired
	CDOfferingRepository cdOfferingRepository;

	@Autowired
	CDAccountRepository cdAccountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	// User methods
	// ======================================================================

	// Add a new user.
	// Before saving, we encode the password!
	public User addUser(User user) {
		String encodedPassword = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

	// Check if user exists
	public boolean userExists(String userName) {
		if (getUserById(userName) == null) {
			return false;
		}
		return true;
	}

	// Get a list of all users.
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	// Search for user by id:
	public User getUserById(String userName) {
		return userRepository.findUserById(userName);
	}

	// Remove user by id:
	public void removeUserById(String userName) {
		userRepository.deleteUserById(userName);
	}

	// Savings account methods
	// ======================================================================

	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount, String userName) {
		getUserById(userName).setSavingsAccount(savingsAccount);
		savingsAccountRepository.save(savingsAccount);
		return savingsAccount;
	}

	public void deleteSavingsAccount(Long id, String userName) {
		userRepository.deleteUserById(userName);
		savingsAccountRepository.deleteById(id);
	}

	public List<SavingsAccount> getSavingsAccounts() {
		return savingsAccountRepository.findAll();
	}

	// Checking account methods
	// ======================================================================

	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount, String userName) {
		getUserById(userName).addCheckingAccount(checkingAccount);
		checkingAccountRepository.save(checkingAccount);
		return checkingAccount;
	}

	public void deleteCheckingAccount(Long id, String userName) {
		savingsAccountRepository.save(getUserById(userName).getSavingsAccount());
		checkingAccountRepository.deleteById(id);
	}

	public List<CheckingAccount> getCheckingAccounts() {
		return checkingAccountRepository.findAll();
	}

	public Optional<CheckingAccount> getCheckingAccountById(long id) {
		return checkingAccountRepository.findById(id);
	}

	public void removeCheckingAccountById(long id) {
		checkingAccountRepository.deleteById(id);
	}

	// CD Account methods
	// ======================================================================

	public double futureValue(CDOffering cdOffering, double balance) {
		return balance * Math.pow(1 + cdOffering.getInterestRate(), cdOffering.getTerm());
	}

	public CDAccount addCDAccount(CDAccount cdAccount, String userName) {
		List<CDOffering> offerings = getCDOfferings();
		List<Double> futureValues = new ArrayList<>();
		for (int i = 0; i < offerings.size(); i++) {
			futureValues.add(futureValue(offerings.get(i), cdAccount.getBalance()));
		}
		cdAccount.setCDOffering(offerings.get(futureValues.indexOf(Collections.max(futureValues))));
		getUserById(userName).addCdAccount(cdAccount);
		cdAccountRepository.save(cdAccount);
		return cdAccount;
	}

	public void deleteCdAccount(Long id, String userName, String closingTo) {
		switch (closingTo) {
		case "Checking":
			personalCheckingAccountRepository.save(getUserById(userName).getPersonalCheckingAccount());
			break;
		case "Savings":
			savingsAccountRepository.save(getUserById(userName).getSavingsAccount());
			break;
		default:
			break;
		}
		cdAccountRepository.deleteById(id);
	}

	public List<CDAccount> getCDAccounts() {
		return cdAccountRepository.findAll();
	}

	public Optional<CDAccount> getCDAccountById(long id) {
		return cdAccountRepository.findById(id);
	}

	public void removeCDAccountById(long id) {
		cdAccountRepository.deleteById(id);
	}

	// CD Offering methods
	// ======================================================================

	public CDOffering addCDOffering(CDOffering cdOffering, long id) {
		return cdOfferingRepository.save(cdOffering);
	}

	public void addCDOfferings() {
		cdOfferingRepository.save(new CDOffering(1, 0.1));
		cdOfferingRepository.save(new CDOffering(2, 0.08));
		cdOfferingRepository.save(new CDOffering(3, 0.06));
		cdOfferingRepository.save(new CDOffering(4, 0.04));
		cdOfferingRepository.save(new CDOffering(5, 0.02));
	}

	public List<CDOffering> getCDOfferings() {
		return cdOfferingRepository.findAll();
	}

	public Optional<CDOffering> getCDOfferingsById(long id) {
		return cdOfferingRepository.findById(id);
	}

	public void removeCDOfferingById(long id) {
		cdOfferingRepository.deleteById(id);
	}

	// DBA Account methods
	// ======================================================================

	public DBAAccount addDBAAccount(DBAAccount dbaAccount, String userName) {
		getUserById(userName).addDbaAccount(dbaAccount);
		dbaRepository.save(dbaAccount);
		return dbaAccount;
	}

	public void deleteDbaAccount(Long id, String userName) {
		savingsAccountRepository.save(getUserById(userName).getSavingsAccount());
		dbaRepository.deleteById(id);
	}

	public List<DBAAccount> getDBAAccount() {
		return dbaRepository.findAll();
	}

	public Optional<DBAAccount> getDBAAccountById(long id) {
		return dbaRepository.findById(id);
	}

	public void removeDBAAccountById(long id) {
		dbaRepository.deleteById(id);
	}

	// RegularIRAccount methods
	// ======================================================================

	public RegularIRA addRegularIraAccount(RegularIRA regularIra, String userName) {
		getUserById(userName).setRegularIra(regularIra);
		regularIRARepository.save(regularIra);
		return regularIra;
	}

	public void deleteRegularIra(Long id, String userName, String closingTo) {
		switch (closingTo) {
		case "Checking":
			personalCheckingAccountRepository.save(getUserById(userName).getPersonalCheckingAccount());
			break;
		case "Savings":
			savingsAccountRepository.save(getUserById(userName).getSavingsAccount());
			break;
		default:
			break;
		}
		regularIRARepository.deleteById(id);
	}

	public List<RegularIRA> getRegularIRAccount() {
		return regularIRARepository.findAll();
	}

	public Optional<RegularIRA> getRegularIRAccountById(long id) {
		return regularIRARepository.findById(id);
	}

	public void removeRegularIRAccountById(long id) {
		regularIRARepository.deleteById(id);
	}

	// RolloverIRAccount methods
	// ======================================================================

	public RolloverIRA addRolloverIraAccount(RolloverIRA rolloverIra, String userName) {
		getUserById(userName).setRolloverIra(rolloverIra);
		rolloverIRARepository.save(rolloverIra);
		return rolloverIra;
	}

	public void deleteRolloverIra(Long id, String userName, String closingTo) {
		switch (closingTo) {
		case "Checking":
			personalCheckingAccountRepository.save(getUserById(userName).getPersonalCheckingAccount());
			break;
		case "Savings":
			savingsAccountRepository.save(getUserById(userName).getSavingsAccount());
			break;
		default:
			break;
		}
		rolloverIRARepository.deleteById(id);
	}

	public List<RolloverIRA> getRolloverIRAccount() {
		return rolloverIRARepository.findAll();
	}

	public Optional<RolloverIRA> getRolloverIRAccountById(long id) {
		return rolloverIRARepository.findById(id);
	}

	public void removeRolloverIRAccountById(long id) {
		rolloverIRARepository.deleteById(id);
	}

	// RothIRAccount methods:

	public RothIRA addRothIraAccount(RothIRA rothIra, String userName) {
		getUserById(userName).setRothIra(rothIra);
		rothIRARepository.save(rothIra);
		return rothIra;
	}

	public void deleteRothIra(Long id, String userName, String closingTo) {
		switch (closingTo) {
		case "Checking":
			personalCheckingAccountRepository.save(getUserById(userName).getPersonalCheckingAccount());
			break;
		case "Savings":
			savingsAccountRepository.save(getUserById(userName).getSavingsAccount());
			break;
		default:
			break;
		}
		rothIRARepository.deleteById(id);
	}

	public List<RothIRA> getRothIRAccount() {
		return rothIRARepository.findAll();
	}

	public Optional<RothIRA> getRothIRAccountById(long id) {
		return rothIRARepository.findById(id);
	}

	public void removeRothIRAccountById(long id) {
		rothIRARepository.deleteById(id);
	}

	// Personal Checking Account Methods
	// ======================================================================

	public PersonalCheckingAccount addPersonalCheckingAccount(PersonalCheckingAccount personalCheckingAccount,
			String userName) {
		getUserById(userName).setPersonalCheckingAccount(personalCheckingAccount);
		personalCheckingAccountRepository.save(personalCheckingAccount);
		return personalCheckingAccount;
	}

	public void deletePersonalCheckingAccount(Long id, String userName) {
		savingsAccountRepository.save(getUserById(userName).getSavingsAccount());
		personalCheckingAccountRepository.deleteById(id);
	}

	// Transaction methods
	// ======================================================================

	public Transaction addTransaction(Transaction transaction, String userName) {

		// Process transaction:
		String type = transaction.getAccountType();

		switch (type) {
		case "Checking Accounts":
			CheckingAccount checkingAccount = checkingAccountRepository.getOne(transaction.getAccountId());
			if (transaction.getAmount() < 0 && Math.abs(transaction.getAmount()) > checkingAccount.getBalance()) {
				transaction.setProcessed(false);
			} else {
				checkingAccount.setBalance(checkingAccount.getBalance() + transaction.getAmount());
				transaction.setProcessed(true);
				checkingAccountRepository.save(checkingAccount);
			}
			break;

		case "Savings Account":
			SavingsAccount savingsAccount = savingsAccountRepository.getOne(transaction.getAccountId());
			if (transaction.getAmount() < 0 && Math.abs(transaction.getAmount()) > savingsAccount.getBalance()) {
				transaction.setProcessed(false);
			} else {
				savingsAccount.setBalance(savingsAccount.getBalance() + transaction.getAmount());
				transaction.setProcessed(true);
				savingsAccountRepository.save(savingsAccount);
			}
			break;
			
		case "Certificate of Deposit Accounts":
			CDAccount cdAccount = cdAccountRepository.getOne(transaction.getAccountId());
			if (transaction.getAmount() < 0 && Math.abs(transaction.getAmount()) > cdAccount.getBalance()) {
				transaction.setProcessed(false);
			} else {
				cdAccount.setBalance(cdAccount.getBalance() + transaction.getAmount());
				transaction.setProcessed(true);
				cdAccountRepository.save(cdAccount);
			}
			break;
			
		case "DBA Checking Accounts":
			DBAAccount DBAAccount = dbaRepository.getOne(transaction.getAccountId());
			if (transaction.getAmount() < 0 && Math.abs(transaction.getAmount()) > DBAAccount.getBalance()) {
				transaction.setProcessed(false);
			} else {
				DBAAccount.setBalance(DBAAccount.getBalance() + transaction.getAmount());
				transaction.setProcessed(true);
				dbaRepository.save(DBAAccount);
			}
			break;
			
		case "Personal Checking Account":
			PersonalCheckingAccount pcAccount = personalCheckingAccountRepository.getOne(transaction.getAccountId());
			if (transaction.getAmount() < 0 && Math.abs(transaction.getAmount()) > pcAccount.getBalance()) {
				transaction.setProcessed(false);
			} else {
				pcAccount.setBalance(pcAccount.getBalance() + transaction.getAmount());
				transaction.setProcessed(true);
				personalCheckingAccountRepository.save(pcAccount);
			}
			break;
			
		case "Regular IRA":
			RegularIRA regIRAccount = regularIRARepository.getOne(transaction.getAccountId());
			if (transaction.getAmount() < 0 && Math.abs(transaction.getAmount()) > regIRAccount.getBalance()) {
				transaction.setProcessed(false);
			} else {
				regIRAccount.setBalance(regIRAccount.getBalance() + transaction.getAmount());
				transaction.setProcessed(true);
				regularIRARepository.save(regIRAccount);
			}
			break;
			
		case "Rollover IRA":
			RolloverIRA rollIRAccount = rolloverIRARepository.getOne(transaction.getAccountId());
			if (transaction.getAmount() < 0 && Math.abs(transaction.getAmount()) > rollIRAccount.getBalance()) {
				transaction.setProcessed(false);
			} else {
				rollIRAccount.setBalance(rollIRAccount.getBalance() + transaction.getAmount());
				transaction.setProcessed(true);
				rolloverIRARepository.save(rollIRAccount);
			}
			break;
			
		case "Roth IRA":
			RothIRA rothIRAccount = rothIRARepository.getOne(transaction.getAccountId());
			if (transaction.getAmount() < 0 && Math.abs(transaction.getAmount()) > rothIRAccount.getBalance()) {
				transaction.setProcessed(false);
			} else {
				rothIRAccount.setBalance(rothIRAccount.getBalance() + transaction.getAmount());
				transaction.setProcessed(true);
				rothIRARepository.save(rothIRAccount);
			}
			break;
			
		default:
			transaction.setProcessed(false);
		}

		getUserById(userName).addTransaction(transaction);
		transactionRepository.save(transaction);
		return transaction;
	}
	
	public List<Transaction> getTransactions() {
		return transactionRepository.findAll();
	}

	public List<Transaction> getTransactionsByUser(String user) {
		return getUserById(user).getTransactions();
	}

	public Optional<Transaction> getTransactionById(long id) {
		return transactionRepository.findById(id);
	}

}