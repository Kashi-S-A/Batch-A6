package com.tyss.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tyss.entity.User;
import com.tyss.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

	private final UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
		
		return org.springframework.security.core.userdetails.
				User
				.withUsername(user.getEmail())
				.password(user.getPassword())
				.build();
	}

}
