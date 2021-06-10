package com.greetotdoor.service;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.UserData;
import com.greetotdoor.exception.UserNotFoundException;


@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired 
	IUserServiceImpl ur;
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
		 System.out.println("outside" +username);	
		 UserData applicationUser = ur.loginUser(username); 
	        return new User(applicationUser.getUsername(),applicationUser.getUserPassword(), emptyList());
//		 return new User("foo","foo",emptyList());
	    }
	
}
