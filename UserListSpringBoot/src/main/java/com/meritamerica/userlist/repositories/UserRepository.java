/*
 * EmployeeRepository
 * ==================
 * 
 * This is a key piece of a Spring Data REST application: a repository definition.
 * This is all that is needed here.
 * 
 * 
 * 
 */

package com.meritamerica.userlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.userlist.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}