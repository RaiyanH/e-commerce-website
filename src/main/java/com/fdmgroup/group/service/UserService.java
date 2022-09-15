package com.fdmgroup.group.service;

import java.util.List;

import com.fdmgroup.group.model.User;

public interface UserService {

	User saveUser(User user);

	void deleteUserById(Long id);

	List<User> findAllUsers();

	User findUserByUsernameAndPassword(String username, String password);

}
