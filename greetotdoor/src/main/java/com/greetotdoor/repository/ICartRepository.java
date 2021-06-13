package com.greetotdoor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.greetotdoor.dao.CartDao;
import com.greetotdoor.entities.CartItemEntity;
import com.greetotdoor.exception.CartException;
import com.greetotdoor.pojos.CartRequest;

@Service
public interface ICartRepository extends JpaRepository<CartItemEntity,Integer>{

}

