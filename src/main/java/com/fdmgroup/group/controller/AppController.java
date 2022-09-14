package com.fdmgroup.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.group.model.User;
import com.fdmgroup.group.model.repository.UserRepository;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/login")
	public String viewLoginPage() {
		return "login";
	}

	@GetMapping("/signup_form")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String showLoginPage(User user) {
		userRepo.save(user);
		return "login";
	}

//	@PostMapping("/process_register")
//	public String processRegister(User user) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String encodedPassword = passwordEncoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);
//
//		userRepo.save(user);
//
//		return "register_success";
//	}

//	@GetMapping("/users")
//	public String listUsers(Model model) {
//		List<User> listUsers = userRepo.findAll();
//		model.addAttribute("listUsers", listUsers);
//
//		return "users";
//	}

}
