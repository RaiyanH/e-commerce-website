package com.fdmgroup.group.controller;

import static org.junit.jupiter.api.Assertions.*;

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
class AppControllerTest {

	@Autowired
	private AppController appContoller;

	@Autowired
	WebApplicationContext webAppContext;
	MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		// Passes the WAC to our mock MVC object so it can perform requests
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	@Test
	public void test_LoginPage_IsReturned_When_ForwadSlash_Login_IsPresent() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/login"))
				.andExpect(MockMvcResultMatchers.view().name("login"));

	}
	@Test
	public void test_SignUp_Form_IsReturned_When_ForwadSlash_SignUp_Form_IsPresent() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/signup_form"))
				.andExpect(MockMvcResultMatchers.view().name("signup_form"));

	}
	@Test
	public void test_login_IsReturned_When_ForwadSlash_process_register_IsPresent() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/process_register"))
		.andExpect(MockMvcResultMatchers.view().name("login"));
		
	}

}
