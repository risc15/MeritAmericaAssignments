package com.meritamerica.bankcapstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.bankcapstone.models.RothIRA;


@Repository
public interface RothIRARepository extends JpaRepository<RothIRA, Long> {

}
