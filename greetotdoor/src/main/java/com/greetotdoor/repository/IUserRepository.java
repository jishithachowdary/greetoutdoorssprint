package com.greetotdoor.repository;

import com.greetotdoor.entities.UserData;

public interface IUserRepository {
	 UserData addUser(UserData user);
	 UserData loginUser(UserData u);
	 UserData logout(UserData user);
}
