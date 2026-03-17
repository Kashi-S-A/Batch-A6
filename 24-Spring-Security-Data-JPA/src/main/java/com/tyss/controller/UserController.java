package com.tyss.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dto.LoginDTO;
import com.tyss.entity.User;
import com.tyss.repo.UserRepo;
import com.tyss.service.JwtService;

@RestController
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		Optional<User> opt = userRepo.findByEmail(user.getEmail());

		if (opt.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Already Registered");
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userRepo.save(user);

		return ResponseEntity.status(HttpStatus.CREATED).body("Registered Successfully");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {

		User user = userRepo.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new RuntimeException("User Not Found"));

		try {
			if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {

				String token = jwtService.generateToken(user.getEmail());

				return ResponseEntity.ok("Token : " + token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.badRequest().body("Invalid credentails");
	}

	@GetMapping("/home")
	public String home() {
		return "Welcome to Home page";
	}

}
