package com.greetotdoor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greetotdoor.entities.UserData;

public interface IUserRepository extends JpaRepository<UserData,Integer>{
//	 UserData addUser(UserData user);
//	 UserData loginUser(UserData u);
//	 UserData logout(UserData user);
}
