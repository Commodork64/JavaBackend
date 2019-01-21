package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {

	@Inject
	private TraineeRepository repo;
	
	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	public Trainee findTrainee(Long id) {
		return repo.findTrainee(id);
	}

	public String addTrainee(String trainee) {
		return repo.addTrainee(trainee);
	}

	public String updateTrainee(Long id, String trainee) {
		return repo.updateTrainee(id, trainee);
	}

	public String removeTrainee(Long id) {
		return repo.removeTrainee(id);
	}

	public TraineeRepository getRepo() {
		return repo;
	}

	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}

}
