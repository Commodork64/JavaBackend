package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;

import com.qa.business.service.GameServiceImplementation;

@Path("/game")
public class GameEndpoints {

	@Inject
	private GameServiceImplementation service;
	
	@Path("/getGames")
	@GET
	@Produces({ "application/json" })
	public String getAllGames() {
		return service.getAllGames();
	}

	@Path("/addGame")
	@POST
	@Produces({ "application/json "})
	public String addGame(String game) {
		return service.addGame(game);
	}

	@Path("/removeGame/{id}")
	@DELETE
	@Produces({ "application/json "})
	public String removeGame(@PathParam("id") Long id) {
		return service.removeGame(id);
	}
	
}
