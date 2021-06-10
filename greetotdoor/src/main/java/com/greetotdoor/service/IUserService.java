package com.greetotdoor.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.greetotdoor.entities.UserData;
import com.greetotdoor.exception.UserNotFoundException;

public interface IUserService {
	
	public UserData addUser(UserData user);

	public UserData loginUser(String username) throws UserNotFoundException;
//	public UserData logout(UserData user);
}

