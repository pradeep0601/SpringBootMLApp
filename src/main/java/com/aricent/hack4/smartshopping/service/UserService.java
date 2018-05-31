package com.aricent.hack4.smartshopping.service;

import java.util.List;

import com.aricent.hack4.smartshopping.model.User;
import com.aricent.hack4.smartshopping.util.UserUtil;

public interface UserService {

	public User registerUser(User user);
	public User updateUser(User user);
	public User deleteUser(User user);
	public User getUser(UserUtil.UserField userField);
	public List<User> getAllUser();
	public List<String> getRecommendations(String selectedItems);
}
