package com.aricent.hack4.smartshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aricent.hack4.smartshopping.model.User;
import com.aricent.hack4.smartshopping.service.UserService;
import com.aricent.hack4.smartshopping.util.MLResponse;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
/**
 * @RequestMapping(value = "/employee/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployeeByName(@PathVariable String name) {
 * @param selectedItems
 * @return
 */
	@RequestMapping(value = "/recommend/{items}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getRecommendation(@PathVariable String items) {
		System.out.println("items: "+items);
		List<String> result = userService.getRecommendations(items);
		return new ResponseEntity<List<String>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MLResponse> registerEmployee(@RequestBody User user) {
		System.out.println("==post: user: "+user);
		if (user == null || user.getUserName() == null) {
			return new ResponseEntity<MLResponse>(new MLResponse("User data is empty"), HttpStatus.BAD_REQUEST);
		}
		User savedData = userService.registerUser(user);
		return new ResponseEntity<MLResponse>(new MLResponse(
				"User with username: " + savedData.getUserName() + ", saved successfuly"), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<MLResponse> getUsers(){
		List<User> users = userService.getAllUser();
		if(users.isEmpty()) {
			return new ResponseEntity<MLResponse>(new MLResponse("No record found for user"), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<MLResponse>(new MLResponse("data retrieved successfuly", users), HttpStatus.OK);
	}
}
