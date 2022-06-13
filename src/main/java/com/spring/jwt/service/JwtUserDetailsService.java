package com.spring.jwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.jwt.DAO.UserDAO;
import com.spring.jwt.model.DaoUser;
import com.spring.jwt.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder bcryptPasswordEncoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DaoUser user=userDAO.findUserByName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("user not found with username "+username);
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
	}

	
	public DaoUser save(UserDTO user) {
		DaoUser newUser = new DaoUser();
		newUser.setUserName(user.getUsername());
		newUser.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		return userDAO.save(newUser);
	
	
}
	}
