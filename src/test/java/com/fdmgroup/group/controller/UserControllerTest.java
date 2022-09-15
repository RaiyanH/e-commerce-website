package com.fdmgroup.group.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

	@Autowired
	private UserController userController;


	@Autowired
	WebApplicationContext webAppContext;
	MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	@Test
	public void test_UserController_Is_Able_To_Load_The_Into_Spring_Context() {
		assertThat(userController).isNotNull();
	}

	@Test
	public void test_LoginPage_IsReturned_When_ForwadSlash_userLogin_IsPresent() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/user/login"))
				.andExpect(MockMvcResultMatchers.view().name("user-login"));

	}

	@Test
	public void test_UserRegister_IsReturned_When_ForwadSlash_UserRegister_IsPresent() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/user/userregister"))
				.andExpect(MockMvcResultMatchers.view().name("user-register"));

	}

	@Test
	public void test_UserLogin_IsShown_When_ForwadSlash_UserRegister_IsPresent() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/user/userregister"))
				.andExpect(MockMvcResultMatchers.view().name("redirect:/user/login"));

	}

	@Test
	public void test_UserLogin_IsReturned_When_User_Dash_Login_IsPresent() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/user/login"))
				.andExpect(MockMvcResultMatchers.view().name("user-login"));

	}

}
