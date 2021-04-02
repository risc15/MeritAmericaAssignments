package com.meritamerica.bankcapstone.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Roth")
public class RothIRA extends IRAccount {

	public RothIRA() {
		
	}
}
