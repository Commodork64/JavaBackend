package com.qa.persistence.repository;

public interface IUserRepository {
	
	String getAllUsers();
	String getGamesOfUser(Long id);
	String addUser(String user);
	String updateUser(Long id, String user);
	String removeUser(Long id);
	

}
