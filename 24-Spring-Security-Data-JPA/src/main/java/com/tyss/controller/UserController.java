package com.tyss.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.entity.User;
import com.tyss.repo.UserRepo;

@RestController
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public String register(@RequestBody User user) {
		Optional<User> opt = userRepo.findByEmail(user.getEmail());

		if (opt.isPresent()) {
			return "Already Registered";
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userRepo.save(user);

		return "Registered successfully";
	}

	@GetMapping("/home")
	public String home() {
		return "Welcome to Home page";
	}

}
