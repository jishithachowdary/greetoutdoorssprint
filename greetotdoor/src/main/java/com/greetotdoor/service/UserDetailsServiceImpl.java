package com.greetotdoor.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.UserData;
import com.greetotdoor.exception.UserNotFoundException;
import com.greetotdoor.repository.IUserRepository;
import com.greetotdoor.util.CustomUserBean;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	IUserRepository userRepository;
	@Autowired
	UserService us;
	@Override
	@Transactional
	//checking if the entered login credentials are valid or not  is not valid an exception is sent
	    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
		 System.out.println("in"+username);
		 UserData user = us.loginUser(username); 
		 System.out.println("out"+user.getUserId());
	        return CustomUserBean.createInstance(user);
//		 return new User("foo","foo",emptyList());
	    }
	
}
