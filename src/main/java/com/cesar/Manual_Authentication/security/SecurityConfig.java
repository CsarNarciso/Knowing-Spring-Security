package com.cesar.Manual_Authentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
			return http.
					
				csrf( csrf -> csrf
					.disable() )
				
				.authorizeHttpRequests( requests -> requests
					.requestMatchers("/authenticate").permitAll()
					.anyRequest().authenticated() )
				
			.build();
	}
	
	
	@Bean
	AuthenticationManager authManager(AuthenticationConfiguration authConfiguration) throws Exception {
		
		return authConfiguration.getAuthenticationManager();
	}
	
	
	
	@Bean
	UserDetailsService userDetailsService() {
		
		return new InMemoryUserDetailsManager();
	}
	
	

}
