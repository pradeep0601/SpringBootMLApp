package com.aricent.hack4.smartshopping.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.aricent.hack4.smartshopping.model.User;

public class UserUtil {
	@Autowired
	private static MongoOperations operations;

	public enum UserField {
		USERNAME, MOBILE, EMAIL
	}

	public static int getNextUserId(String keyName) {
		Query query = new Query(Criteria.where("_id").is(keyName));
		Update update = new Update();
		update.inc("seq", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		
		User user = operations.findAndModify(query, update, options, User.class);
		return user.getUserId();
	}
}
