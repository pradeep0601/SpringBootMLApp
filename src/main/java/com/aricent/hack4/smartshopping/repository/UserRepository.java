package com.aricent.hack4.smartshopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aricent.hack4.smartshopping.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {

	public User findByUserName(String userName);// naming syntax : findBy<property name of model>

	public User findByEmail(String email);

	public User findByMobile(String mobile);

}
