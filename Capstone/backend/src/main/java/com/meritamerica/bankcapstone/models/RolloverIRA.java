package com.meritamerica.bankcapstone.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Rollover")
public class RolloverIRA extends IRAccount {

	public RolloverIRA() {
		
	}
}
