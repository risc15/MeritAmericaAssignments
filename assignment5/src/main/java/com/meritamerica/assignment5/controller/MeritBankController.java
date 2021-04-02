package com.meritamerica.assignment5.controller;

import com.meritamerica.assignment5.models.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;

@RestController
public class MeritBankController {

	List<AccountHolder> accountHolders = new ArrayList<AccountHolder>();
	List<CDOffering> cdOfferings = new ArrayList<CDOffering>();
	List<String> stringTemp = new ArrayList<String>();

	@GetMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.OK)
	public AccountHolder[] getAccountHolder() {
		return MeritBank.getAccountHolders();
	}

	@PostMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@Valid @RequestBody AccountHolder accountHolder) {
		MeritBank.addAccountHolder(accountHolder);
		return accountHolder;
	}

	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getAccountHolderById(@PathVariable(name = "id") int id) throws Exception {
		AccountHolder account = MeritBank.getAccountHolderById(id);
		if (account == null) {
			throw new Exception("ID Not Found");
		}
		return account;
	}

	// ===========================
	// **** Checking Accounts ****
	// ===========================

	@PostMapping("/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@Valid @PathVariable(name = "id") long id,
			@RequestBody CheckingAccount checkingAccount)
			throws Exception, ExceedsCombinedBalanceLimitException, NegativeAmountException {
		AccountHolder account = MeritBank.getAccountHolderById(id);
		account.addCheckingAccount(checkingAccount);
		return checkingAccount;
	}

	@GetMapping("/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public CheckingAccount[] getCheckingAccounts(@PathVariable(name = "id") long id) throws Exception {
		AccountHolder account = MeritBank.getAccountHolderById(id);
		if (account == null) {
			throw new Exception("ID Not Found");
		}
		return account.getCheckingAccounts();
	}

	// ==========================
	// **** Savings Accounts ****
	// ==========================

	@PostMapping("/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@Valid @PathVariable(name = "id") long id,
			@RequestBody SavingsAccount savingsAccount)
			throws Exception, ExceedsCombinedBalanceLimitException, NegativeAmountException {
		AccountHolder account = MeritBank.getAccountHolderById(id);
		account.addSavingsAccount(savingsAccount);
		return savingsAccount;
	}

	@GetMapping("/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.OK)
	public SavingsAccount[] getSavingsAccounts(@PathVariable(name = "id") long id) throws Exception {
		AccountHolder account = MeritBank.getAccountHolderById(id);
		if (account == null) {
			throw new Exception("ID Not Found");
		}
		return account.getSavingsAccounts();
	}

	// =====================
	// **** CD Accounts ****
	// =====================

	@PostMapping("/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccount(@Valid @PathVariable(name = "id") long id, @RequestBody CDAccount cdAccount)
			throws Exception, ExceedsCombinedBalanceLimitException, NegativeAmountException {
		AccountHolder account = MeritBank.getAccountHolderById(id);
		account.addCDAccount(cdAccount);
		return cdAccount;
	}

	@GetMapping("/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.OK)
	public CDAccount[] getCDAccounts(@PathVariable(name = "id") long id) throws Exception {
		AccountHolder account = MeritBank.getAccountHolderById(id);
		if (account == null) {
			throw new Exception("ID Not Found");
		}
		return account.getCDAccounts();
	}

	// ======================
	// **** CD Offerings ****
	// ======================

	@PostMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering createCDOffering(@Valid @RequestBody CDOffering cdOffering) {
		MeritBank.addCDOfferings(cdOffering);
		return cdOffering;
	}

	@GetMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.OK)
	public CDOffering[] getCDOfferings() throws Exception {
		CDOffering[] cdOfferings = MeritBank.getCDOfferings();
		return cdOfferings;
	}

}
