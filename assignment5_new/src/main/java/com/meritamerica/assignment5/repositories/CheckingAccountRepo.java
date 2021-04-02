package com.meritamerica.assignment5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meritamerica.assignment5.models.CheckingAccount;

public interface CheckingAccountRepo extends JpaRepository<CheckingAccount, Long> {
	
}
