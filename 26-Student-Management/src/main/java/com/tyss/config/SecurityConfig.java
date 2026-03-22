package com.tyss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		
		http.csrf(c -> c.disable())
			.authorizeHttpRequests(req -> req
					.requestMatchers("/register","/login")
					.permitAll()
					.requestMatchers("/WEB-INF/**")
					.permitAll()
					.anyRequest()
					.authenticated()
			)
			.formLogin(f-> f
					.loginPage("/login")//GET
					.loginProcessingUrl("/auth")//POST
					.defaultSuccessUrl("/dashboard")
					.failureUrl("/login?error=Invalid credentials")
					.permitAll()
			)
			.logout(l -> l.logoutUrl("/logout").permitAll());
			
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
