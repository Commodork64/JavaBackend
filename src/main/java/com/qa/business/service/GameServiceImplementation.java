package com.qa.business.service;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.qa.persistence.repository.GameDBRepository;

public class GameServiceImplementation {
	
	@Inject
	private GameDBRepository gameRepo;
	
	public String getAllGames() {
		return gameRepo.getAllGames();
	}

	@Transactional(REQUIRED)
	public String addGame(String game) {
		return gameRepo.addGame(game);
	}
	
	@Transactional(REQUIRED)
	public String removeGame(Long id) {
		return gameRepo.removeGame(id);
	}

}
