package com.tyss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tyss.entity.User;
import com.tyss.repo.UserRepo;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("USER NOT FOUND"));

		return org.springframework.security.core.userdetails.
				User.withUsername(user.getEmail())
					.password(user.getPassword())
					.build();
	}

}
