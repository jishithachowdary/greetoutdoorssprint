package com.greetotdoor.repository;

import com.greetotdoor.entities.UserData;

public interface IUserRepository {
	public UserData addUser(UserData user);
	public UserData loginUser(UserData u);
	public UserData logout(UserData user);
}
