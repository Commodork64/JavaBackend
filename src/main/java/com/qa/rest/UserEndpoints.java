package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.UserServiceImplementation;

@Path("/user")
public class UserEndpoints {
	
	@Inject
	private UserServiceImplementation service;

	@Path("/getAllUsers")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllUsers();
	}
	
	@Path("/addUser")
	@POST
	@Produces({ "application/json" })
	public String addTrainee(String user) {
		return service.addUser(user);
	}

	@Path("/updateUser/{id}")
	@POST
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Long id, String user) {
		return service.updateUser(id, user);
	}

	@Path("/removeUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeTrainee(@PathParam("id") Long id) {
		return service.removeUser(id);
	}

}
