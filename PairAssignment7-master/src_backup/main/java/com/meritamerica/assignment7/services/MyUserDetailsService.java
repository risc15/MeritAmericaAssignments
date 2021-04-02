package com.meritamerica.assignment7.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment7.models.MyUserDetails;
import com.meritamerica.assignment7.models.Users;
import com.meritamerica.assignment7.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Username not found."));
		return user.map(MyUserDetails::new).get();
	}
	
	public Optional<Users> loadUserById(long id) {
		return userRepository.findById(id);
	}
	
	public Users postNewUser(Users user) {
		return userRepository.save(user);
	}
}
