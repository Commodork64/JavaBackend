package com.qa.persistence.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id
		private Long userid;

		private String userName;
		private String dateOfBirth;
		private String password;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "userid")
	private Set<Game> games;
	
	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public Set<Game> getGames() {
		return games;
	}

	public User() {

	}

	public User(Long userid, String userName, String dateOfBirth, String password) {
		this.userid = userid;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.password = password;

	}
	
	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
