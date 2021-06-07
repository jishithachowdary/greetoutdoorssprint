package com.greetotdoor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greetotdoor.entities.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity,Integer>{

}
