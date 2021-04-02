package com.meritamerica.assignment5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.assignment5.models.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long> {
	
}