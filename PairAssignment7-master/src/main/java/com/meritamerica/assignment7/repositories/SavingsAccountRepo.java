package com.meritamerica.assignment7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment7.models.SavingsAccount;

public interface SavingsAccountRepo extends JpaRepository<SavingsAccount, Long> {

}
