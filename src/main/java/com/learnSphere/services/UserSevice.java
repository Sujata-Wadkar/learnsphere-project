package com.learnSphere.services;

import com.learnSphere.entity.Users;
public interface UserSevice {
	//add new user
	String addUser(Users user);
	//check email already present in database or not
	boolean checkEmail(String email);
	
	//validate user creditionls
	boolean validate(String email,String password);
	String role(String email);
	
}
