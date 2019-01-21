package com.qa.persistence.repository;

import com.qa.persistence.domain.Trainee;

public interface TraineeRepository {
	
	String getAllTrainees();
	Trainee findTrainee(Long id);
	String addTrainee(String trainee);
	String updateTrainee(Long id, String trainee);
	String removeTrainee(Long id);

}
