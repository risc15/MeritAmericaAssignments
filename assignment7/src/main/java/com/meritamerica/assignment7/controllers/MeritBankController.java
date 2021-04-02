package com.meritamerica.assignment7.controllers;
import com.meritamerica.assignment7.exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment7.exceptions.NegativeAmountException;
import com.meritamerica.assignment7.exceptions.NotFoundException;
import com.meritamerica.assignment7.models.*;
import com.meritamerica.assignment7.security.JwtUtil;
import com.meritamerica.assignment7.security.MyUserDetailsService;
import com.meritamerica.assignment7.services.MeritBankService;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
public class MeritBankController {
	
	@Autowired
	MeritBankService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	public List<AccountHolder> accountHolders = new ArrayList<AccountHolder>();
	public List<CDOffering> cdOfferings = new ArrayList<CDOffering>();
	
	@GetMapping("/")
	public String home() {
		return (
				"<h1>Bank App</h1>" +
				"<p>Welcome to the bank! You need to make an account to access our features.</p>"
		);
	}
	
	@GetMapping("/admin")
	public String adminConsole() {
		return (
				"<h1>Bank App Admin Console</h1>" +
				"<p>You're the head honcho. The big cheese. The giant rat who makes all of the rules.</p>"
		);
	}
	
	@GetMapping("/main")
	public String mainPage() {
		return (
				"<h1>Bank User's Portal</h1>" +
				"<p>Loads of money!</p>"
		);
	}

	@GetMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolder> getAccountHolder() {
		return service.getAccountHolders();
	}

	@PostMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@Valid @RequestBody AccountHolder accountHolder) {
		service.postAccountHolder(accountHolder);
		accountHolders.add(accountHolder);
		return accountHolder;
	}

	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getAccountHolderById(@PathVariable(name = "id") long id) throws NotFoundException {
		
		if (id > accountHolders.size()) {
			throw new NotFoundException("No such id found.");
		}
		
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				return acct;
			}
		}
		
		return service.getAccountHolderById(id);
	}

	// ===========================
	// **** Checking Accounts ****
	// ===========================

	@PostMapping("/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@Valid @PathVariable(name = "id") long id, @RequestBody CheckingAccount checkingAccount)
			throws Exception, ExceedsCombinedBalanceLimitException, NegativeAmountException, NotFoundException {
		
		if (id > accountHolders.size()) {
			throw new NotFoundException("No such id found!");
		}
		
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				if (checkingAccount.getBalance() < 0) {
					throw new Exception("Negative balance is not allowed.");
				} else if (checkingAccount.getBalance() + acct.getCombinedBalance() > 250000) {
					throw new Exception("Cannot exceed $250,000 across all accounts.");
				}
				
				checkingAccount.setAccountHolder(acct);
				acct.checkingAccounts.add(checkingAccount);
			}
		}
		
		service.postCheckingAccount(checkingAccount, id);
		return checkingAccount;
	}

	@GetMapping("/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CheckingAccount> getCheckingAccounts(@PathVariable(name = "id") long id) throws Exception {
		
		if (id > accountHolders.size()) {
			throw new Exception("No such id found!");
		}
		
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				return acct.checkingAccounts;
			}
		}
		return accountHolders.get((int) id).getCheckingAccounts();
	}

	// ==========================
	// **** Savings Accounts ****
	// ==========================

	@PostMapping("/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@Valid @PathVariable(name = "id") long id, @RequestBody SavingsAccount savingsAccount)
			throws Exception, ExceedsCombinedBalanceLimitException, NegativeAmountException, NotFoundException {
		
		if (id > accountHolders.size()) {
			throw new NotFoundException("No such id found!");
		}
		
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				if (savingsAccount.getBalance() < 0) {
					throw new Exception("Negative balance is not allowed.");
				} else if (acct.getCombinedBalance() > 250000) {
					throw new Exception("Cannot exceed $250000 across all accounts.");
				}
				
				savingsAccount.setAccountHolder(acct);
				acct.savingsAccounts.add(savingsAccount);
			}
		}
		
		service.postSavingsAccount(savingsAccount, id);
		return savingsAccount;
	}

	@GetMapping("/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<SavingsAccount> getSavingsAccounts(@PathVariable(name = "id") long id) throws Exception {
		
		if (id > accountHolders.size()) {
			throw new Exception("No such id found!");
		}
		
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				return acct.savingsAccounts;
			}
		}
		return accountHolders.get((int) id).getSavingsAccounts();
	}

	// =====================
	// **** CD Accounts ****
	// =====================

	@PostMapping("/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccount(@Valid @PathVariable(name = "id") long id, @RequestBody CDAccount cdAccount)
			throws Exception, ExceedsCombinedBalanceLimitException, NegativeAmountException, NotFoundException {
		
		if (id > accountHolders.size()) {
			throw new NotFoundException("No such id found!");
		}
		
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				if (cdAccount.getBalance() < 0) {
					throw new Exception("Negative balance is not allowed.");
				} else if (acct.getCombinedBalance() > 250000) {
					throw new Exception("Cannot exceed $250000 across all accounts.");
				}
				
				cdAccount.setAccountHolder(acct);
				acct.cdAccounts.add(cdAccount);
			}
		}
		
		service.postCDAccount(cdAccount, id);
		return cdAccount;
	}

	@GetMapping("/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CDAccount> getCDAccounts(@PathVariable(name = "id") long id) throws Exception {
		
		if (id > accountHolders.size()) {
			throw new Exception("No such id found!");
		}
		
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				return acct.cdAccounts;
			}
		}
		return accountHolders.get((int) id).getCDAccounts();
	}

	// ======================
	// **** CD Offerings ****
	// ======================

	@PostMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering createCDOffering(@Valid @RequestBody CDOffering cdOffering) {
		cdOfferings.add(cdOffering);
		return service.postCDOffering(cdOffering);
	}

	@GetMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.OK)
	public List<CDOffering> getCDOfferings() throws Exception {

		return service.getCDOfferings();
	}
	
	// ========================
	// **** Authentication ****
	// ========================
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
				);
		} catch (BadCredentialsException e){
			throw new Exception("Incorrect username or password.", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	

}
