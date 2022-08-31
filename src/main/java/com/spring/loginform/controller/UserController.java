package com.spring.loginform.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.spring.loginform.model.UserTable;
import com.spring.loginform.service.UserService;

@Controller
// @RequestMapping(value="/user") //http://localhost:8085/user
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("registerRequest", new UserTable());
		return "register_page";
	}

	@GetMapping(value = "/login")
	public String getLoginPage(Model model) {
		model.addAttribute("loginRequest", new UserTable());
		return "login_page";
	}

	@PostMapping(value="/login")
	public String login(@ModelAttribute("userTable") UserTable userTable) {
		UserTable oauth = userService.findByLoginAndPassword(userTable.getLogin(), userTable.getPassword());
		System.out.println(oauth);
		if (Objects.nonNull(oauth)) {
			return "personal_page";
		} else {
			return "error_page";
		}
	}

	@PostMapping(value="/register") 
	public String register(@ModelAttribute UserTable userTable) {
	System.out.println("register request:"+userTable);
	UserTable registeredUser =userService.registerUser(userTable.getLogin(),
	userTable.getPassword(),userTable.getEmail());
	return registeredUser == null ? "error_page":"login_page"; 
	}

}
