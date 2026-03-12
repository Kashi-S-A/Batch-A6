package com.tyss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		
		//filters
		http.csrf(c -> c.disable())
			.authorizeHttpRequests( req -> 
				req.requestMatchers("/user/**")
				   .hasAnyRole("USER","ADMIN")
				   .requestMatchers("/admin/**")
				   .hasRole("ADMIN")
				   .requestMatchers("/public/**")
				   .permitAll()
				   .anyRequest()
				   .authenticated()
					)
			.formLogin(f -> Customizer.withDefaults())
			.logout(l -> Customizer.withDefaults())
			;

		return http.build();
	}
	
	
	@Bean
	public UserDetailsService inMemoryUsers() {
		UserDetails user1 = User.withUsername("Manga")
								.password("{noop}Manga@123")
								.roles("USER")
								.build();
		
		UserDetails user2 = User.withUsername("Mangi")
								.password("{noop}Mangi@123")
								.roles("ADMIN")
								.build();
		
		return new InMemoryUserDetailsManager(user1,user2);
	}
	
	
	
	
	
}
