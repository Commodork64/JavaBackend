package com.qa.persistence.repository;

import com.qa.persistence.domain.User;

public interface IUserRepository {
	
	String getAllUsers();
	User findUser(Long id);
	String addUser(String user);
	String updateUser(Long id, String user);
	String removeUser(Long id);

}
