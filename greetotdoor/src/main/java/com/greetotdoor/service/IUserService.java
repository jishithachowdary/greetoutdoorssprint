package com.greetotdoor.service;

import com.greetotdoor.entities.UserData;

public interface IUserService {
	
	public UserData addUser(UserData user);

//	public UserData loginUser(UserData u);
	public UserData logout(UserData user);
}

