package com.meritamerica.assignment1;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		AccountHolder bill = new AccountHolder("Masaki","Bill","Sonezaki","123121234",100,1000);
		System.out.println(bill);
		
		bill.getCheckingAccount().deposit(500);
		bill.getCheckingAccount().withdraw(800);
		System.out.println(bill.getCheckingAccount());
		System.out.println(bill.getSavingsAccount());
		
		AccountHolder moneyBags = new AccountHolder("Money","B","Moneybags","999999999",200,500);
		moneyBags.getCheckingAccount().deposit(-500);
		moneyBags.getSavingsAccount().withdraw(600);
		System.out.println(moneyBags);
	}
}