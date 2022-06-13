package com.spring.jwt.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.jwt.model.DaoUser;

@Repository
public interface UserDAO extends CrudRepository<DaoUser, Long> {


	
	public DaoUser findUserByName(String username);

	
	
}
