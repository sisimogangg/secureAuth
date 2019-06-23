package io.galaxsci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.galaxsci.model.User;
import io.galaxsci.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByUsername(username);
		CustomUserDetails userDetails = null;
		if(user != null ) {
			userDetails = new CustomUserDetails();
			userDetails.setUser(user);
		}else  throw new UsernameNotFoundException("User does not exist");
		
		return userDetails;
	}

}
