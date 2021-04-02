package com.meritamerica.assignment5.models;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.Entity;

@Entity
public class CDOffering {

		private static int term;
		private static double interestRate;
	
		public CDOffering()	{
		
		}
		public CDOffering(int term, double interestRate) {
			CDOffering.term = term;
			CDOffering.interestRate = interestRate;
		}
	

		public static int getTerm() {return term;}

		public static double getInterestRate() {return interestRate;}
		
		public static CDOffering readFromString(String cdOfferingDataString) {
			CDOffering cdOff;
			ArrayList<String> aL = new ArrayList<>(Arrays.asList(cdOfferingDataString.split(",")));
//			System.out.println(aL.get(0) + "," + aL.get(1));
			cdOff = new CDOffering(Integer.parseInt(aL.get(0)), Double.parseDouble(aL.get(1)));
			return cdOff;
		}
		
		public String writeToString() {
			return term + "," + interestRate;
		}
}