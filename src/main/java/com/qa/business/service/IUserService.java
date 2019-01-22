package com.qa.business.service;

import com.qa.persistence.domain.User;

public interface IUserService {
	
	String getAllUsers();
	User findUser(Long id);
	String addUser(String trainee);
	String updateUser(Long id, String trainee);
	String removeUser(Long id);

}
