package com.test.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.db.model.User;
import com.test.db.repo.userRepo;

import java.util.List;
import java.util.Optional;

@Service
public class userSer {
	
	@Autowired
	private userRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	public void AddUser(User user)
	{
		
	user.setPassword(encoder.encode(user.getPassword()));
		
		repo.save(user);

	}

	public List<User> findUser(User user) {

		List<User> user1 = repo.findAll();


		return user1;
	}

	public String testUser(){
		return  "okkkk";
	}


public User getByUserName(String name){
		Optional<User> user= repo.findByUserName(name);
		User user1=user.orElseThrow();

		return user1;
}
	

}
