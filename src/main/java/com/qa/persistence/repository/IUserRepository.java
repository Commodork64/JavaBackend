package com.qa.persistence.repository;

import com.qa.persistence.domain.Trainee;

public interface IUserRepository {
	
	String getAllUsers();
	Trainee findUser(Long id);
	String addUser(String user);
	String updateUser(Long id, String user);
	String removeUser(Long id);

}
