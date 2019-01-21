package com.qa.business.service;

import com.qa.persistence.domain.Trainee;

public interface IUserService {
	
	String getAllUsers();
	Trainee findUser(Long id);
	String addUser(String trainee);
	String updateUser(Long id, String trainee);
	String removeUser(Long id);

}
