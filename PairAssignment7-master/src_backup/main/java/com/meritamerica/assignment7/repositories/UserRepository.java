package com.meritamerica.assignment7.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment7.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	Optional<Users> findByUsername(String username);
}
