package com.meritamerica.assignment7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment7.models.CheckingAccount;

public interface CheckingAccountRepo extends JpaRepository<CheckingAccount, Long> {
	
}
