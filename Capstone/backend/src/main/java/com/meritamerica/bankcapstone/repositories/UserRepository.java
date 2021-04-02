package com.meritamerica.bankcapstone.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meritamerica.bankcapstone.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.userName = :userName")
	User findUserById(@Param("userName") String userName);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM User u WHERE u.userName = :userName")
	void deleteUserById(@Param("userName") String userName);
	
}
