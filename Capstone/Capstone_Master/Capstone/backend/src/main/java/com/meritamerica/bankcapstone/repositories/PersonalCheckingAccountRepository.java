package com.meritamerica.bankcapstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.bankcapstone.models.PersonalCheckingAccount;


@Repository
public interface PersonalCheckingAccountRepository extends JpaRepository<PersonalCheckingAccount, Long> {

}
