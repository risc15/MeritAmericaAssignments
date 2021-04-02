/*
 * DatabaseLoader
 * ==============
 * 
 * This file pre-loads the application with some data.
 * 
 */

package com.meritamerica.userlist.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.meritamerica.userlist.models.User;
import com.meritamerica.userlist.repositories.UserRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final UserRepository repository;

	@Autowired
	public DatabaseLoader(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		this.repository.save(new User("Froggo", "Bibbins", "ring bearer", "bibbinz@magicmail.com"));
		this.repository.save(new User("Hawkeye", "urmomshou", "Expendagamer Leader", "acdcHAWKacdc@koolmail4kidz.com"));
		this.repository.save(new User("Mad Rat", "The Rat", "Lab Rat", "madratdead@ratmail.com"));
	}
}