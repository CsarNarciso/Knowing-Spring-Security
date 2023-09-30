package com.cesar.Manual_Authentication.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
			return http.
					
				csrf( csrf -> csrf
					.disable() )
				
				.authorizeHttpRequests( requests -> requests
					.requestMatchers("/authenticate/..").permitAll()
					.anyRequest().authenticated() )
				
			.build();
	}
	
	
	
	UserDetailsService userDetailsService() {
		
		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		
		userDetailsService.createUser( new User("cesar", "123", null) );
		
		return userDetailsService;		
	}
}
