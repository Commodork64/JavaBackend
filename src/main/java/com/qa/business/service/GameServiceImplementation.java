package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.GameDBRepository;

public class GameServiceImplementation {
	
	@Inject
	private GameDBRepository gameRepo;
	
	public String getAllGames() {
		return gameRepo.getAllGames();
	}

}
