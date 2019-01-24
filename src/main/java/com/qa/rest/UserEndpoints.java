package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	public String getAllUsers() {
		return service.getAllUsers();
	}
	
	@Path("/addUser")
	@POST
	@Produces({ "application/json" })
	public String addUser(String user) {
		return service.addUser(user);
	}

	@Path("/updateUser/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("id") Long id, String user) {
		return service.updateUser(id, user);
	}

	@Path("/removeUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeUser(@PathParam("id") Long id) {
		return service.removeUser(id);
	}

}
