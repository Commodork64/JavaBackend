package com.qa.business.service;

import javax.inject.Inject;

import com.google.gson.Gson;
import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserDBRepository;

public class UserServiceImplementation implements IUserService {

	@Inject
	private UserDBRepository userRepo;
	
	public String getAllUsers() {
		return userRepo.getAllUsers();
	}

	public String addUser(String user) {
		Gson gson = new Gson();
		User tempUser = gson.fromJson(user, User.class);
		
		if (userRepo.getUsernameList().contains(tempUser.getUserName())) {
			return "unluckee";
		}
		return userRepo.addUser(user);
	}

	public String updateUser(Long id, String user) {
		return userRepo.updateUser(id, user);
	}

	public String removeUser(Long id) {
		return userRepo.removeUser(id);
	}

	public UserDBRepository getRepo() {
		return userRepo;
	}

	public void setRepo(UserDBRepository repo) {
		this.userRepo = repo;
	}
	
	public String getAllGames() {
		return userRepo.getAllGames();
	}

}
