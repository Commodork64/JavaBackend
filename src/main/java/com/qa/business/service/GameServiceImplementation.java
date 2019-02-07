package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.GameDBRepository;

public class GameServiceImplementation {
	
	@Inject
	private GameDBRepository gameRepo;
	
	public String getAllGames() {
		return gameRepo.getAllGames();
	}

	public String addGame(Long id, String game) {
		return gameRepo.addGame(id, game);
	}

	public String removeGame(Long id) {
		return gameRepo.removeGame(id);
	}

}
