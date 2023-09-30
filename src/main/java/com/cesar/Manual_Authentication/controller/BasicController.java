package com.cesar.Manual_Authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
	
	
	@GetMapping("/authenticate")
	String authenticate(){
		
		return "Login system will be here. It's public to everyone!";
	}
	
	
	@GetMapping("/access")
	String authenticatedAccess(){
		
		return "You're authenticated!";
	}
}
