package com.greetotdoor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.UserData;
import com.greetotdoor.exception.UserNotFoundException;
import com.greetotdoor.repository.IUserRepository;




@Service
public class UserService {
	@Autowired
	IUserRepository ur;
	public UserData loginUser(String username) throws UserNotFoundException{
		 System.out.println("in"+username);
		 System.out.println(ur.findAll());
		 for(UserData u:ur.findAll()) {
			 System.out.println(u.getUserId()+" a "+username);
			 if(u.getUserId().equals(username)) {
				 return u;
			 }
		 }
		 return null;
	 }

}
