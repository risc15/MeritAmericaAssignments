package com.meritamerica.assignment7.models;

public class FraudQueue {
	
	private static Transaction fraudTransaction;
	
	FraudQueue() {
		
	}
	
	public static void addTransaction(Transaction transaction) {
		fraudTransaction = transaction;
	}
	
	public Transaction getTransaction() {
		return fraudTransaction;
	}
	
}
