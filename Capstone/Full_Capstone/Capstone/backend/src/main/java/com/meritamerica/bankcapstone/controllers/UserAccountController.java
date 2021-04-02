package com.meritamerica.bankcapstone.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.bankcapstone.models.CDAccount;
import com.meritamerica.bankcapstone.models.CheckingAccount;
import com.meritamerica.bankcapstone.models.DBAAccount;
import com.meritamerica.bankcapstone.models.PersonalCheckingAccount;
import com.meritamerica.bankcapstone.models.RegularIRA;
import com.meritamerica.bankcapstone.models.RolloverIRA;
import com.meritamerica.bankcapstone.models.RothIRA;
import com.meritamerica.bankcapstone.models.SavingsAccount;
import com.meritamerica.bankcapstone.models.User;
import com.meritamerica.bankcapstone.services.UserAccountService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserAccountController {

	@Autowired
	UserAccountService service;
	
	// User APIs =======================================================
	
	// Get all users:
	
	@GetMapping(value = "/Users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUsers(){
		return service.getUsers();
	}
	
	// Get user by id:
	
	@GetMapping("/Users/{userName}")
	@ResponseStatus(HttpStatus.OK)
	public User fetchUserById(@PathVariable("userName") String userName) {
		return service.getUserById(userName);
	}
	
	// Post user:
	
	@PostMapping(value = "/Users")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) { //validation goes here, too.
		service.addUser(user);
		return user;
	}
	
	// Delete user:
	
	@DeleteMapping("/Users/{userName}")
	@ResponseStatus(HttpStatus.OK)
	public void removeUserById(@PathVariable("userName") String userName) {
		service.removeUserById(userName);
	}
	
	// Get APIs =======================================================
	
	@GetMapping(value = "/Users/{userName}/Checking Account")
	@ResponseStatus(HttpStatus.OK)
	public List<CheckingAccount> getCheckingAccounts(@PathVariable("userName") String userName){
		return service.getUserById(userName).getCheckingAccounts();
	}
	
	@GetMapping(value = "/Users/{userName}/Savings Account")
	@ResponseStatus(HttpStatus.OK)
	public SavingsAccount getSavingsAccount(@PathVariable("userName") String userName){
		return service.getUserById(userName).getSavingsAccount();
	}
	
	
	// Post APIs ======================================================
	
	@PostMapping(value = "/Users/{userName}/Checking Account")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount postCheckingAccount(@PathVariable("userName") String userName, @RequestBody @Valid CheckingAccount checkingAccount) {
		return service.addCheckingAccount(checkingAccount, userName);
	}
	
	@PostMapping(value = "/Users/{userName}/Savings Account")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount postSavingsAccount(@PathVariable("userName") String userName, @RequestBody @Valid SavingsAccount savingsAccount) {
		return service.addSavingsAccount(savingsAccount, userName);
	}
	
	@PostMapping(value = "/Users/{userName}/Personal Checking Account")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonalCheckingAccount postPersonalCheckingAccount(@PathVariable("userName") String userName, @RequestBody @Valid PersonalCheckingAccount personalCheckingAccount) {
		return service.addPersonalCheckingAccount(personalCheckingAccount, userName);
	}
	
	@PostMapping(value = "/Users/{userName}/DBA Checking Account")
	@ResponseStatus(HttpStatus.CREATED)
	public DBAAccount postDBAAccount(@PathVariable("userName") String userName, @RequestBody @Valid DBAAccount dbaAccount) {
		return service.addDBAAccount(dbaAccount, userName);
	}
	
	@PostMapping(value = "/Users/{userName}/Certificate of Deposit Account")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount postCDAccount(@PathVariable("userName") String userName, @RequestBody @Valid CDAccount cdAccount) {
		return service.addCDAccount(cdAccount, userName);
	}
	
	@PostMapping(value = "/Users/{userName}/Regular IRA")
	@ResponseStatus(HttpStatus.CREATED)
	public RegularIRA postRegularIraAccount(@PathVariable("userName") String userName, @RequestBody @Valid RegularIRA regularIra) {
		return service.addRegularIraAccount(regularIra, userName);
	}
	
	@PostMapping(value = "/Users/{userName}/Rollover IRA")
	@ResponseStatus(HttpStatus.CREATED)
	public RolloverIRA postRolloverIRA(@PathVariable("userName") String userName, @RequestBody @Valid RolloverIRA rolloverIra) {
		return service.addRolloverIraAccount(rolloverIra, userName);
	}
	
	@PostMapping(value = "/Users/{userName}/Roth IRA")
	@ResponseStatus(HttpStatus.CREATED)
	public RothIRA postRothIRA(@PathVariable("userName") String userName, @RequestBody @Valid RothIRA rothIra) {
		return service.addRothIraAccount(rothIra, userName);
	}
	
	// Patch Mapping ======================================================
	
	@PatchMapping(value = "/Users/{userName}/Checking Accounts/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void removeCheckingAccount(@PathVariable("userName") String userName, @PathVariable("id") Long id) {
		service.getUserById(userName).deleteCheckingAccount(id);
		service.deleteCheckingAccount(id);
	}
		
	@PatchMapping(value = "/Users/{userName}/Savings Account/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void removeSavingsAccount(@PathVariable("userName") String userName, @PathVariable("id") Long id) {
		service.getUserById(userName).deleteSavingsAccount();
		service.deleteSavingsAccount(id);
	}
	
	@PatchMapping(value = "/Users/{userName}/Personal Checking Account/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void removePersonalAccount(@PathVariable("userName") String userName, @PathVariable("id") Long id) {
		service.getUserById(userName).deletePersonalCheckingAccount();
		service.deletePersonalCheckingAccount(id);
	}
	
	@PatchMapping(value = "/Users/{userName}/DBA Checking Accounts/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void removeDBAAccount(@PathVariable("userName") String userName, @PathVariable("id") Long id) {
		service.getUserById(userName).deleteDbaAccount(id);
		service.deleteDbaAccount(id);
	}
	
	@PatchMapping(value = "/Users/{userName}/Certificate of Deposit Accounts/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void removeCDAccount(@PathVariable("userName") String userName, @PathVariable("id") Long id) {
		service.getUserById(userName).deleteCdAccount(id);
		service.deleteCdAccount(id);
	}
	
	@PatchMapping(value = "/Users/{userName}/Regular IRA/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void removeRegularIra(@PathVariable("userName") String userName, @PathVariable("id") Long id) {
		service.getUserById(userName).deleteRegularIra();
		service.deleteRegularIra(id);
	}
	
	@PatchMapping(value = "/Users/{userName}/Rollover IRA/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void removeRolloverIra(@PathVariable("userName") String userName, @PathVariable("id") Long id) {
		service.getUserById(userName).deleteRolloverIra();
		service.deleteRolloverIra(id);
	}
	
	@PatchMapping(value = "/Users/{userName}/Roth IRA/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void removeRothIra(@PathVariable("userName") String userName, @PathVariable("id") Long id) {
		service.getUserById(userName).deleteRothIra();
		service.deleteRothIra(id);
	}

}
