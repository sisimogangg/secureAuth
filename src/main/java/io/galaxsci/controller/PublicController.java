package io.galaxsci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.galaxsci.model.User;
import io.galaxsci.repository.UserRepository;

@RestController
@RequestMapping("/api/public")
public class PublicController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping
	public String getMessage() {
		return "Hello from public API Controller";
	}
	
	
	@PostMapping
	public String addUserByAdmin(@RequestBody User user) {
		
		String password = user.getPassword();
		String encryptPwd = passwordEncoder.encode(password);
		user.setPassword(encryptPwd);
		
		userRepository.save(user);
		return "User added successfully";
	}
}
