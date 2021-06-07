package com.greetotdoor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greetotdoor.entities.UserData;
import com.greetotdoor.service.IUserServiceImpl;

@RestController
public class UserController {
	@Autowired
	IUserServiceImpl us;
	@RequestMapping(method=RequestMethod.POST,value="/user/insert")
	public UserData addUser(@RequestBody UserData user) {
		return us.addUser(user);
	}
}
