package com.meritamerica.assignment7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment7.models.UserAccount;

public interface UserAccountRepo extends JpaRepository<UserAccount, Long>{

}
