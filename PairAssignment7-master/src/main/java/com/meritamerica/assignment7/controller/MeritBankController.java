/*
 * 
 */

package com.meritamerica.assignment7.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment7.exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment7.exceptions.NegativeAmountException;
import com.meritamerica.assignment7.exceptions.NotFoundException;
import com.meritamerica.assignment7.exceptions.RequiredException;
import com.meritamerica.assignment7.models.*;
import com.meritamerica.assignment7.security.JwtUtil;
import com.meritamerica.assignment7.services.MeritBankService;
import com.meritamerica.assignment7.services.MyUserDetailsService;


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

	//public List<AccountHolder> accountHolders = new ArrayList<>();
	public List<CDOffering> cdOfferings = new ArrayList<>();
	
	// Getting list of account holders ////////////////////////////////////////////////////////////////////////
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolder> getAccountHolders(){
		return service.getAccountHolders();
	}
	
	// Posting an account holder //////////////////////////////////////////////////////////////////////////////
	@PreAuthorize("hasAuthority('admin')")
	@PostMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		service.addAccountHolder(accountHolder);
		return accountHolder;
	}
	
	@GetMapping("/user/{id}/")
	@ResponseStatus(HttpStatus.OK)
	public AccountHolder fetchUserById(@PathVariable("id") Long id) {
		return service.getAccountHolderById(id);
	}
	
	// Getting account holder by id ///////////////////////////////////////////////////////////////////////////
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getAccountHolderById(
			@PathVariable(name = "id") long id) throws NotFoundException {
		if (id > service.getAccountHolders().size()) {
			throw new NotFoundException("No such id!");
		}
		for (AccountHolder acct : service.getAccountHolders()) {
			if (acct.getId() == id) {
				return acct;
			}
		}
		return service.getAccountHolderById(id);
	}
	
	// Checking Account Stuff ///////////////////////////////////////////////////////////////////////////////
	@PreAuthorize("hasAuthority('admin')")
	@PostMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	public CheckingAccount addCheckingAccount(
			@PathVariable(name = "id") long id,
			@RequestBody @Valid CheckingAccount checkingAccount) throws Exception, NotFoundException {
		if (id > service.getAccountHolders().size()) {
			throw new NotFoundException("No such id!");
		}
		for (AccountHolder acct : service.getAccountHolders()) {
			if (acct.getId() == id) {
				if (checkingAccount.getBalance() < 0) throw new Exception("Negative balance not allowed!");
				else if (acct.getCombinedBalance() > 250000) throw new Exception("Cannot exceed $250,000 across all accounts!");
				checkingAccount.setAccountHolder(acct);
				acct.checkingAccounts.add(checkingAccount);
			}
		}
		service.addCheckingAccount(checkingAccount, id);
		return checkingAccount;
		
	}
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping("/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CheckingAccount> getCheckingAccounts(@PathVariable(name = "id") long id) throws Exception, NotFoundException {
		if (id > service.getAccountHolders().size()) throw new NotFoundException("No such id!");
		for (AccountHolder acct : service.getAccountHolders()) {
			if (acct.getId() == id) {
				return acct.checkingAccounts;
			}
		}
		
		return service.getAccountHolderById(id).getCheckingAccounts();
	}
	
	// Savings Account Stuff ///////////////////////////////////////////////////////////////////////////////
	@PreAuthorize("hasAuthority('admin')")
	@PostMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	public SavingsAccount addSavingsAccount(
			@PathVariable(name = "id") long id,
			@RequestBody @Valid SavingsAccount savingsAccount) throws Exception, NotFoundException {
		if (id > service.getAccountHolders().size()) {
			throw new NotFoundException("No such id!");
		}
		for (AccountHolder acct : service.getAccountHolders()) {
			if (acct.getId() == id) {
				if (savingsAccount.getBalance() < 0) throw new Exception("Negative balance not allowed!");
				else if (acct.getCombinedBalance() > 250000) throw new Exception("Cannot exceed $250,000 across all accounts!");
				savingsAccount.setAccountHolder(acct);
				acct.savingsAccounts.add(savingsAccount);
			}
		}
		service.addSavingsAccount(savingsAccount, id);
		return savingsAccount;
		
	}
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping("/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<SavingsAccount> getSavingsAccounts(@PathVariable(name = "id") long id) throws Exception, NotFoundException {
		if (id > service.getAccountHolders().size()) throw new NotFoundException("No such id!");
		for (AccountHolder acct : service.getAccountHolders()) {
			if (acct.getId() == id) {
				return acct.savingsAccounts;
			}
		}
		
		return service.getAccountHolderById(id).getSavingsAccounts();
	}
	
	// CDAccount Stuff ///////////////////////////////////////////////////////////////////////////////////
	@PreAuthorize("hasAuthority('admin')")
	@PostMapping(value = "/AccountHolders/{id}/CDAccounts")
	public CDAccount addCDAccount(
			@PathVariable(name = "id") long id,
			@RequestBody @Valid CDAccount cdAccount) throws Exception, NotFoundException {
		if (id > service.getAccountHolders().size()) {
			throw new NotFoundException("No such id!");
		}
		for (AccountHolder acct : service.getAccountHolders()) {
			if (acct.getId() == id) {
				if (cdAccount.getBalance() < 0) throw new Exception("Negative balance not allowed!");
				else if (acct.getCombinedBalance() > 250000) throw new Exception("Cannot exceed $250,000 across all accounts!");
				cdAccount.setAccountHolder(acct);
				acct.cdAccounts.add(cdAccount);
			}
		}
		service.addCDAccount(cdAccount, id);
		return cdAccount;
		
	}
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping("/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CDAccount> getCDAccounts(@PathVariable(name = "id") long id) throws Exception, NotFoundException {
		if (id > service.getAccountHolders().size()) throw new NotFoundException("No such id!");
		for (AccountHolder acct : service.getAccountHolders()) {
			if (acct.getId() == id) {
				return acct.cdAccounts;
			}
		}
		
		return service.getAccountHolderById(id).getCDAccounts();
	}
	
	// CD Offerings ///////////////////////////////////////////////////////////////////////////////////
	@PreAuthorize("hasAuthority('admin')")
	@PostMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering createCDOffering(@RequestBody CDOffering cdOffering) {
		cdOfferings.add(cdOffering);
		return service.addCDOffering(cdOffering);
	}
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.OK)
	public List<CDOffering> getCDOfferings() { 
		return service.getCDOfferings();
	}
	
	// Authentication Stuff ////////////////////////////////////////////////////////////////////////////
	
	@PreAuthorize("hasAuthority('admin')")
	@PostMapping("/authenticate/createUser")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		return service.registerUser(signUpRequest);
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
				);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect ussername or password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
}
