package com.cesar.Manual_Authentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;


@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
			return http
				
				.csrf( csrf -> csrf
					.disable() )
				
				.exceptionHandling( exHandling -> exHandling
						.authenticationEntryPoint( new LoginUrlAuthenticationEntryPoint("/login")) )
				
				.authorizeHttpRequests( requests -> requests
					.requestMatchers("/access").authenticated()
					.anyRequest().permitAll() ) 
					
			.build();
	}
	

	
	
	
	@Bean
	AuthenticationManager authManager(AuthenticationConfiguration authConfiguration) throws Exception {
		
		return authConfiguration.getAuthenticationManager();
	}
	
	
	
	@Bean
	UserDetailsService userDetailsService() {
		
		var userDetails = new InMemoryUserDetailsManager();
		
		userDetails.createUser( User.withUsername("cesar").password( passwordEncoder().encode("123") ).build() );
		
		return userDetails;		
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
