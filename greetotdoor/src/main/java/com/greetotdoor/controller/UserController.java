package com.greetotdoor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greetotdoor.entities.Response;
import com.greetotdoor.entities.UserData;
import com.greetotdoor.service.MyUserDetailsService;
import com.greetotdoor.util.JwtUtil;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;



@RestController
public class UserController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	MyUserDetailsService userDetailsService;
	@Autowired
	JwtUtil jwtTokenUtil;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	@RequestMapping(value="/aauthenticate",method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserData userData) throws Exception {
		try {
			
			String name=userData.getUsername();
			System.out.println("userData"+ userData);
			System.out.println("name"+userData.getUsername());
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userData.getUsername(),userData.getUserPassword()));
		}catch(BadCredentialsException e) {
			throw new Exception("incorrect username or password");
		}
		final UserDetails userDetails=userDetailsService.loadUserByUsername(userData.getUsername());
		final String jwt=jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new Response(jwt));
		
	}

	
	
	
	
}
