package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class GameDBRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllGames() {
		Query query = manager.createQuery("Select g FROM Game g");
		@SuppressWarnings("unchecked")
		Collection<User> result = (Collection<User>) query.getResultList();
		return util.getJSONForObject(result);
	}

	public String addGame(String game) {
		Game gameToAdd = util.getObjectForJSON(game, Game.class);
		//gameToAdd.setUserid(id);
		manager.persist(gameToAdd);
		return "Game added to list.";
	}

	public String removeGame(Long id) {
		Game gameToDelete = (Game) manager.createQuery("Select g FROM Game g WHERE gameid = " + id).getSingleResult();
		if (gameToDelete != null) {
			manager.remove(gameToDelete);
		}
		return "Game removed from list.";
	}

}
