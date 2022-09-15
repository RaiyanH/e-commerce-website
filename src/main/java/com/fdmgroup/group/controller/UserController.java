package com.fdmgroup.group.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.group.model.Login;
import com.fdmgroup.group.model.User;
import com.fdmgroup.group.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/userregister")
	public String lunchUserRegistertPage(Model model) {
		model.addAttribute("user", new User());
		return "user-register";
	}

	@PostMapping("/userregister")
	public String saveUser(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "user-register";
		}
		this.userService.saveUser(user);
		return "redirect:/user/login";
	}

	@GetMapping("/remove/{id}")
	public String deleteUserById(@PathVariable("id") long id) {
		this.userService.deleteUserById(id);
		return "redirect:/admin2";
	}

	@GetMapping("/login")
	public String viewLoginPage() {
		return "user-login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute(name = "loginForm") Login login, Model m) {
		String username = login.getUsername();
		String password = login.getPassword();
		User savedUser = this.userService.findUserByUsernameAndPassword(username, password);
		if (savedUser != null) {
			return "Index";
		}

		m.addAttribute("error", "Incorrect Username & Password");
		return "user-login";

	}

}
