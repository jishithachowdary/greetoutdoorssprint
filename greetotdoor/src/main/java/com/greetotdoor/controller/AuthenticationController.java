package com.greetotdoor.controller;



import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greetotdoor.entities.AuthResponse;
import com.greetotdoor.entities.UserData;
import com.greetotdoor.repository.IUserRepository;
import com.greetotdoor.util.CustomUserBean;
import com.greetotdoor.util.JwtTokenUtil;



@RestController
public class AuthenticationController {
	@Autowired
	IUserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtTokenUtil jwtTokenUtil;
// if the user already exits then the user can login using the credentials	
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody UserData user) {
		System.out.println("AuthController -- userLogin");
		Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUserId(), user.getUserPassword()));	
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenUtil.generateJwtToken(authentication);
		CustomUserBean userBean = (CustomUserBean) authentication.getPrincipal();		
		Collection<? extends GrantedAuthority> roles = userBean.getAuthorities();
		AuthResponse authResponse = new AuthResponse();
		authResponse.setToken(token);
		authResponse.setRoles(roles);
		return ResponseEntity.ok(authResponse);
	}
//if the user does not have account the user can create a new account	
	@PostMapping("/signup")
	@JsonIgnore
	public ResponseEntity<?> userSignup( @RequestBody UserData signupRequest) {
//		if(userRepository.existsByUserId(signupRequest.getUserId())){
//			return ResponseEntity.badRequest().body("Username is already taken");
//		}
		UserData user = new UserData();
		user.setUserId(signupRequest.getUserId());
		user.setUserPassword(encoder.encode(signupRequest.getUserPassword()));
		System.out.println("Encoded password--- " + user.getUserPassword());
		user.setUserType(signupRequest.getUserType());
		userRepository.save(user);
		return ResponseEntity.ok("User signed up successfully");
	}
}
