package com.fdmgroup.group.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fdmgroup.group.model.User;
import com.fdmgroup.group.model.repository.UserRepository;

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	private UserService userService;

	@MockBean
	UserRepository mockUserRepository;
	
	@MockBean
	User mockUser;
	
	@Test
	void test_User_From_ServiceLayer_Is_Deleted_From_Repository() {
        userService.deleteUserById(2L);
        verify(mockUserRepository).deleteById(2L);
    }
	@Test
	void test_All_Users_From_ServiceLayer_Is_Found_From_Repository() {
		userService.findAllUsers();
		verify(mockUserRepository).findAll();
	}
	@Test
	void test_Users_From_ServiceLayer_Is_Saved_From_Repository() {
		userService.saveUser(mockUser);
		verify(mockUserRepository).save(mockUser);
	}
	@Test
	void test_Users_From_ServiceLayer_Is_Found_By_Username_And_Password_From_Repository() {
		userService.findUserByUsernameAndPassword("testname","testpass");
		verify(mockUserRepository).findByUsernameAndPassword("testname","testpass");
	}

	
}
