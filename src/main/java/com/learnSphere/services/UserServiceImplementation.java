package com.learnSphere.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Users;
import com.learnSphere.repository.UserRepository;
@Service
public  class UserServiceImplementation implements UserSevice {
	@Autowired
	UserRepository repo;
	

	@Override
	public String addUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return "Student added succesfully";
		
	}


	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return repo.existsByEmail(email);
	}


	@Override
	public boolean validate(String email, String password) {
		if(repo.existsByEmail(email)) {
			Users u=repo.getByEmail(email);
			
			
			String dbpassword=u.getPassword();
			if(password.equals(dbpassword)) {
				
				return true;
			}
			else {
				return false;
			}
		}
		else {
		return false;
	}
	}


	@Override
	public String role(String email) {
		 Users user = repo.getByEmail(email);
	        return user.getRole();
	}


	

	
		
}



	

	

