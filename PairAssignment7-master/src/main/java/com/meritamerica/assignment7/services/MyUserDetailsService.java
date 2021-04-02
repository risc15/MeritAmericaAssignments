package com.meritamerica.assignment7.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.meritamerica.assignment7.models.MyUserDetails;
import com.meritamerica.assignment7.models.User;
import com.meritamerica.assignment7.repositories.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
			
		
		  Optional<User> user = userRepo.findByUsername(username);
		  user.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
		  
		  return user.map(MyUserDetails::new).get();
		 
	}
}
