package com.meritamerica.assignment7.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamerica.assignment7.models.ERole;
import com.meritamerica.assignment7.models.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{
	
	Optional<Role> findByName(ERole name);

}
