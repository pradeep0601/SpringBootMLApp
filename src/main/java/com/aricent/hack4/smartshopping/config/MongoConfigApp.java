package com.aricent.hack4.smartshopping.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * 
 * @author Pradeep
 *
 */
@Configuration
@PropertySource("classpath:config.properties")
public class MongoConfigApp {

	@Autowired
	private Environment env;

	@Bean
	public Mongo mongo() throws Exception {
		System.out.println("======mongo()========");
		String MONGO_HOST = env.getProperty("mongo.db.host");
		int MONGO_PORT = Integer.parseInt(env.getProperty("mongo.db.port"));

		return new MongoClient(MONGO_HOST, MONGO_PORT);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		System.out.println("======mongoTemplate()========");
		String MONGO_DB_NAME = env.getProperty("mongo.db.dataBaseName");

		return new MongoTemplate((MongoClient) mongo(), MONGO_DB_NAME);
	}
}
