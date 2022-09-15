package com.fdmgroup.group.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fdmgroup.group.model.Role;
import com.fdmgroup.group.model.User;
import com.fdmgroup.group.model.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	private UserRepository userRepository;

	public UserServiceImp(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		user.setRole(Role.USER);
		return this.userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		this.userRepository.deleteById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		return this.userRepository.findByUsernameAndPassword(username, password);
	}

}
