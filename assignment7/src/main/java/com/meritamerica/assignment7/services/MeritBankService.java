package com.meritamerica.assignment7.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment7.models.AccountHolder;
import com.meritamerica.assignment7.models.CDAccount;
import com.meritamerica.assignment7.models.CDOffering;
import com.meritamerica.assignment7.models.CheckingAccount;
import com.meritamerica.assignment7.models.SavingsAccount;
import com.meritamerica.assignment7.repositories.AccountHolderRepo;
import com.meritamerica.assignment7.repositories.CDAccountRepo;
import com.meritamerica.assignment7.repositories.CDOfferingRepo;
import com.meritamerica.assignment7.repositories.CheckingAccountRepo;
import com.meritamerica.assignment7.repositories.SavingsAccountRepo;


@Service
public class MeritBankService {
	@Autowired
	AccountHolderRepo accountHolderRepository;
	
	@Autowired
	CDAccountRepo cdAccountRepository;
	
	@Autowired
	CheckingAccountRepo checkingAccountRepository;
	
	@Autowired
	SavingsAccountRepo savingsAccountRepository;
	
	@Autowired
	CDOfferingRepo cdOfferingRepository;
	
	
	public AccountHolder postAccountHolder(AccountHolder accountHolder) {
		return accountHolderRepository.save(accountHolder);
	}
	
	public List<AccountHolder> getAccountHolders(){
		return accountHolderRepository.findAll();
	}
	
	public AccountHolder getAccountHolderById(long id) {
		return accountHolderRepository.getOne(id);
	}
	
	public SavingsAccount postSavingsAccount(SavingsAccount savingsAccount, long id) {
		return savingsAccountRepository.save(savingsAccount);
	}
	
	public List<SavingsAccount> getSavingsAccounts(){
		return savingsAccountRepository.findAll();
	}
	
	public CDAccount postCDAccount(CDAccount cdAccount, long id) {
		return cdAccountRepository.save(cdAccount);
	}
	
	public List<CDAccount> getCDAccounts(){
		return cdAccountRepository.findAll();
	}
	
	public CheckingAccount postCheckingAccount(CheckingAccount checkingAccount, long id) {
		return checkingAccountRepository.save(checkingAccount);
	}
	
	public List<CheckingAccount> getCheckingAccounts(){
		return checkingAccountRepository.findAll();
	}
	
	public CDOffering postCDOffering(CDOffering cdOffering) {
		return cdOfferingRepository.save(cdOffering);
	}
	
	public List<CDOffering> getCDOfferings(){
		return cdOfferingRepository.findAll();
	}

}
