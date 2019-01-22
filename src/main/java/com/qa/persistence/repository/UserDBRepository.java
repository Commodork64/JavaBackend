package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

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
		Query query = manager.createQuery("Select a FROM Trainee a");
		@SuppressWarnings("unchecked")
		Collection<User> trainees = (Collection<User>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	public User findUser(Long id) {
		return manager.find(User.class, id);
	}

	@Transactional(REQUIRED)
	public String addUser(String trainee) {
		User aTrainee = util.getObjectForJSON(trainee, User.class);
		manager.persist(aTrainee);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateUser(Long id, String trainee) {
		User traineeInDB = findUser(id);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
			User traineeUpdateInDB = util.getObjectForJSON(trainee, User.class);
			manager.persist(traineeUpdateInDB);
		}
		return "{\"message\": \"trainee has been sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String removeUser(Long id) {
		User traineeInDB = findUser(id);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
		}
		return "{\"message\": \"trainee has been sucessfully removed\"}";
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
