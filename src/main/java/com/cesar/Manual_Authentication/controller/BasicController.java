package com.cesar.Manual_Authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController("/")
public class BasicController {
	
	
	
	@RequestMapping("login")
	String login() {
		
		return "Not authenticated. This sumulates the redirect to the login page.";
	}
	
	
	
	@RequestMapping("authenticate/{name}/{password}")
	void authenticate(@PathVariable String name, @PathVariable String password, HttpSession session){
			
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(name, password);
	
		Authentication authentication = authManager.authenticate( token );	
		
		SecurityContext sc = SecurityContextHolder.getContext();
		
		sc.setAuthentication( authentication );

		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);		
	}
	
	
	
	
	@RequestMapping("access")
	String authenticatedAccess(){
		
		return "You're authenticated!";
	}
	
	
	
	
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	UserDetailsService uds;
}
