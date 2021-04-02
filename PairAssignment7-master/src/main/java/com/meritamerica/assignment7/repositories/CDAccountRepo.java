package com.meritamerica.assignment7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment7.models.CDAccount;

public interface CDAccountRepo extends JpaRepository<CDAccount, Long> {

}
