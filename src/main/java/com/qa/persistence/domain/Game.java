package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "GAME")
public class Game {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long gameid;

	private String gameName;
	private String releaseYear;
	private String genre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private User user;
	
	public Game(Long gameid, String gameName, String releaseYear, String genre) {
		this.gameid = gameid;
		this.gameName = gameName;
		this.releaseYear = releaseYear;
		this.genre = genre;
	}
	
	public Game() {
		
	}
	
	public Long getGameid() {
		return gameid;
	}

	public void setGameid(Long gameid) {
		this.gameid = gameid;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
