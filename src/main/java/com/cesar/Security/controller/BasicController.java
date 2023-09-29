package com.cesar.Security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
	
	
	@RequestMapping("/login")
	String login(){
		
		return "Here will be the login system! It's public to everyone!";
	}
	
	
	@RequestMapping("/any")
	String anyAuthenticatedAccess(){
		
		return "You're authenticated!";
	}
}
