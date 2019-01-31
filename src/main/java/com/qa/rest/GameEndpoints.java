package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
	
}
