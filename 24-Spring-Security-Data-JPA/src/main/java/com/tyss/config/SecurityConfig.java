package com.tyss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tyss.filter.AppFilter;
import com.tyss.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AppFilter appFilter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		
		http.csrf(c -> c.disable())
			.authorizeHttpRequests(req -> req
					.requestMatchers("/register","/login")
					.permitAll()
					.anyRequest()
					.authenticated())
					.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.authenticationProvider(authenticationProvider())
					.addFilterBefore(appFilter, UsernamePasswordAuthenticationFilter.class);
		
					//session creation policy stateless
					// auth provider
					// filter before(appfilter,uandpassauth)
		
		
		return http.build();
	}
	
	
	// Auth manager
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) {
		
		return config.getAuthenticationManager();
	}
	
	// Auth Provider
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userService);
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
