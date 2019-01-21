package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.TraineeService;

@Path("/training")
public class TraineeEndpoints {
	
	@Inject
	private TraineeService service;

	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();
	}
	
	@Path("/addTrainee/")
	@POST
	@Produces({ "application/json" })
	public String addTrainee(String trainee) {
		return service.addTrainee(trainee);
	}

	@Path("/updateTrainee/{id}")
	@POST
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Long id, String trainee) {
		return service.updateTrainee(id, trainee);
	}

	@Path("/removeTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeTrainee(@PathParam("id") Long id) {
		return service.removeTrainee(id);
	}
	
	public TraineeService getService() {
		return service;
	}

	public void setService(TraineeService service) {
		this.service = service;
	}

}
