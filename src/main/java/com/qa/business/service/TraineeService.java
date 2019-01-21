package com.qa.business.service;

import com.qa.persistence.domain.Trainee;

public interface TraineeService {
	
	String getAllTrainees();
	Trainee findTrainee(Long id);
	String addTrainee(String trainee);
	String updateTrainee(Long id, String trainee);
	String removeTrainee(Long id);

}
