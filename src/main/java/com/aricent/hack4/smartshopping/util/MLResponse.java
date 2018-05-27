package com.aricent.hack4.smartshopping.util;

import java.util.List;

import com.aricent.hack4.smartshopping.model.User;

/**
 * 
 * @author Pradeep
 *
 */
public class MLResponse {

	private String message;
	private User user;
	private List<User> users;

	public MLResponse(String message,List<User> users) {
		super();
		this.message = message;
		this.users = users;
	}

	public MLResponse(String message, User user) {
		super();
		this.message = message;
		this.user = user;
	}

	public MLResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
