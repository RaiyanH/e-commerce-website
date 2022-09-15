package com.fdmgroup.group.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.fdmgroup.group.model.Login;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String viewLoginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute(name = "loginForm") Login login, Model m) {
		String username = login.getUsername();
		String password = login.getPassword();
		if (username.equals("Admin") && password.equals("admin")) {
			m.addAttribute("username", username);
			m.addAttribute("password", password);
			return "admin-task-page";
		}
		m.addAttribute("error", "Incorrect Username & Password");
		return "login";
	}

}
