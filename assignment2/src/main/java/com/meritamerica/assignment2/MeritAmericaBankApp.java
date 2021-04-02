package com.meritamerica.assignment2;

import java.util.Arrays;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		
    	CDOffering[] CDOfferings = new CDOffering[5];
    	
    	CDOfferings[0] = new CDOffering(1,1.8/100);
    	CDOfferings[1] = new CDOffering(2,1.9/100);
    	CDOfferings[2] = new CDOffering(3,2.0/100);
    	CDOfferings[3] = new CDOffering(5,2.5/100);
    	CDOfferings[4] = new CDOffering(10,2.2/100);
    	MeritBank.setCDOfferings(CDOfferings);
    	
    	AccountHolder ah1 = new AccountHolder("Jackie", "Chan", "Chan","1234567891");
    	CheckingAccount checkingAccount =new CheckingAccount(1000);
    	SavingsAccount savingsAccount = new SavingsAccount(10000);
    	
    	CheckingAccount checkingAccount2 =new CheckingAccount(5000);
    	SavingsAccount savingsAccount2 = new SavingsAccount(50000);
    	
    	CheckingAccount checkingAccount3 =new CheckingAccount(50000);
    	SavingsAccount savingsAccount3 = new SavingsAccount(500000);
    	
       	CheckingAccount checkingAccount4 =new CheckingAccount(5000);
    	SavingsAccount savingsAccount4 = new SavingsAccount(50000);   
    	
    	ah1.addCheckingAccount(checkingAccount);
    	ah1.addSavingsAccount(savingsAccount);
    	ah1.addCheckingAccount(checkingAccount2);
    	ah1.addSavingsAccount(savingsAccount2);
    	ah1.addCheckingAccount(checkingAccount3);
    	ah1.addSavingsAccount(savingsAccount3);
    	ah1.addCheckingAccount(checkingAccount4);
    	ah1.addSavingsAccount(savingsAccount4);
    	
    	
    	
    	
	}
}