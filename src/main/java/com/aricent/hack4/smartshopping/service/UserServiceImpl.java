package com.aricent.hack4.smartshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aricent.hack4.smartshopping.model.User;
import com.aricent.hack4.smartshopping.repository.UserRepository;
import com.aricent.hack4.smartshopping.util.RecommendationEngine;
import com.aricent.hack4.smartshopping.util.UserUtil;
import com.aricent.hack4.smartshopping.util.UserUtil.UserField;

@Service
public class UserServiceImpl implements UserService {

	private static final String KEY_NAME = "userId";
	
	@Autowired
	private UserRepository repository;

	@Override
	public User registerUser(User user) {
		//user.setUserId(UserUtil.getNextUserId(KEY_NAME));
		return repository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(UserField userField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		return repository.findAll();
	}

	@Override
	public List<String> getRecommendations(String selectedItems) {
		List<String> result = null;
		try {
			result = RecommendationEngine.recommend(selectedItems);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
