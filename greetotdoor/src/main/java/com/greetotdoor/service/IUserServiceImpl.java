package com.greetotdoor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.UserData;
import com.greetotdoor.repository.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService{
	@Autowired
	IUserRepository ur;
	public UserData addUser(UserData user) {
		return ur.save(user);
	}
}
