package com.fdmgroup.group.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.group.model.User;
import com.fdmgroup.group.model.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;

	@Autowired
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	// Save User
	public void saveUser(User user) {
		this.userRepo.save(user);
	}
}
