package com.greetotdoor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.greetotdoor.entities.UserData;

@Service
public interface IUserRepository extends JpaRepository<UserData,Integer>{
//	 UserData addUser(UserData user);
//	 UserData loginUser(UserData u);
//	 UserData logout(UserData user);
}
