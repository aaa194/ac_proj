package com.ac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/list")
	public String listUsers(Model theModel) {
		
		//front page with list of all users
		return "list-users";
		
	}

}
