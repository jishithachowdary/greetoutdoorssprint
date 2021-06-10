package com.greetotdoor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.greetotdoor.entities.UserData;
import com.greetotdoor.exception.UserNotFoundException;
import com.greetotdoor.repository.IUserRepository;

import static java.util.Collections.emptyList;

@Service
public class IUserServiceImpl implements IUserService{
	@Autowired
	IUserRepository ur;
	private IUserRepository applicationUserRepository;
	
	 public IUserServiceImpl(IUserRepository applicationUserRepository) {
	        this.applicationUserRepository = applicationUserRepository;
	    }
	public UserData addUser(UserData user) {
		return ur.save(user);
	}
	


	 public UserData loginUser(String username) throws UserNotFoundException{
		 for(UserData u:ur.findAll()) {
			 System.out.println("out inside"+u.getUsername()+" "+username);
			 if(u.getUsername().equals(username)) {
				 System.out.println("inside"+u.getUsername());
				 return u;
			 }
		 }
		 return null;
	 }
}
