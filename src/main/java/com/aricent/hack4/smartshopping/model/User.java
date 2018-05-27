package com.aricent.hack4.smartshopping.model;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	@Indexed
	private int userId;
	@UniqueElements
	private String userName;
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private String address;

	public int getUserId() {
		return userId;
	}

	/*public void setUserId(int userId) {
		this.userId = userId;
	}*/

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", gender="
				+ gender + ", address=" + address + "]";
	}

}