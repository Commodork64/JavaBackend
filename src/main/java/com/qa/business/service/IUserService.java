package com.qa.business.service;

public interface IUserService {
	
	//users
	String getAllUsers();
	String addUser(String trainee);
	String updateUser(Long id, String trainee);
	String removeUser(Long id);
	
	//games
	String getAllGames();
}
