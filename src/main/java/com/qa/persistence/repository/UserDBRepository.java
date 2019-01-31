package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
public class UserDBRepository implements IUserRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllUsers() {
		Query query = manager.createQuery("Select a FROM User a");
		@SuppressWarnings("unchecked")
		Collection<User> result = (Collection<User>) query.getResultList();
		return util.getJSONForObject(result);
	}
	
	public String getUsernameList() {

		List<User> results = manager
                .createQuery("Select a from User a", User.class)
                .getResultList();
		ArrayList<String> userNames = new ArrayList<String>();
		
		for(User user : results) {
			userNames.add(user.getUserName());
		}
		
		return listToString(userNames);
	} 
	
	private String listToString(List<?> list) {
		String result = "";
		for (int i = 0; i < list.size(); i++) {
			result += " " + list.get(i);
		}
		return result;
	}

	public User findUser(Long id) {
		return manager.find(User.class, id);
	}

	@Transactional(REQUIRED)
	public String addUser(String user) {
		User newUser = util.getObjectForJSON(user, User.class);
//		for(int i = 0; i <= getUsernameList().size() - 1; i++) {
//			if (newUser.getUserName().equals(getUsernameList().get(i))) {
//				return "{\"message\": \"username already taken!\"}";
//			}
//		}
		manager.persist(newUser);
		return "{\"message\": \"user has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateUser(Long id, String user) {
		User userInDB = findUser(id);
		if (userInDB != null) {
			manager.remove(userInDB);
			User updatedUser = util.getObjectForJSON(user, User.class);
			manager.persist(updatedUser);
		}
		return "{\"message\": \"user has been sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String removeUser(Long id) {
		User userToDelete = findUser(id);
		if (userToDelete != null) {
			manager.remove(userToDelete);
		}
		return "{\"message\": \"user has been sucessfully removed\"}";
	}
	
	@Transactional(REQUIRED)
	public String getAllGames() {
		Query query = manager.createQuery("Select a FROM Game a");
		@SuppressWarnings("unchecked")
		Collection<Game> result = (Collection<Game>) query.getResultList();
		return util.getJSONForObject(result);
	
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
