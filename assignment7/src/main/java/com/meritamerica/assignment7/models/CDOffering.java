package com.meritamerica.assignment7.models;

import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

@Entity
public class CDOffering {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Min(value = 1, message = "Term must be greater than 0")
	private static int term;
	
	@NotNull
	@DecimalMin(value = "0.0", inclusive = false, message = "InterestRate must be 0 < i < 1")
	@DecimalMax(value = "1.0", inclusive = false, message = "InterestRate must be 0 < i < 1")
	private static double interestRate;

	public CDOffering() {

	}

	public CDOffering(int term, double interestRate) {
		CDOffering.term = term;
		CDOffering.interestRate = interestRate;
	}

	public static int getTerm() {
		return term;
	}

	public static double getInterestRate() {
		return interestRate;
	}

	public static CDOffering readFromString(String cdOfferingDataString) {
		CDOffering cdOff;
		ArrayList<String> aL = new ArrayList<>(Arrays.asList(cdOfferingDataString.split(",")));
		cdOff = new CDOffering(Integer.parseInt(aL.get(0)), Double.parseDouble(aL.get(1)));
		return cdOff;
	}

	public String writeToString() {
		return term + "," + interestRate;
	}
}