package com.meritamerica.assignment3;

public class CDOffering {
	
	/*
	 * Instance Variables:
	 */
	
	private double interestRate;
	private int term;
	
	/*
	 * Constructor:
	 */
	
	CDOffering(int term, double interestRate) {
		this.interestRate = interestRate;
		this.term = term;
	}
	
	/*
	 * Methods:
	 */
	
	int getTerm() {
		return this.term;
	}
	double getInterestRate() {
		return this.interestRate;
	}
	
	public static CDOffering readFromString(String cdOfferingDataString) {
        String[] str = cdOfferingDataString.split(",");
        //System.out.println(str[0] + " " + str[1]);
        return new CDOffering(Integer.parseInt(str[0]), Double.parseDouble(str[1]));
    }

	public String writeToString() {
		String newString = this.interestRate + "," + this.term;
		return newString;
	}

}