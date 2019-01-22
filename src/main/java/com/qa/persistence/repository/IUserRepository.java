package com.qa.persistence.repository;

public interface IUserRepository {
	
	String getAllUsers();
	String addUser(String user);
	String updateUser(Long id, String user);
	String removeUser(Long id);
	

}
