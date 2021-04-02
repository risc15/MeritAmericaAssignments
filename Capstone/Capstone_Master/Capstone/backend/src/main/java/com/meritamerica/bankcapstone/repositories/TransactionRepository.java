package com.meritamerica.bankcapstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.bankcapstone.models.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}