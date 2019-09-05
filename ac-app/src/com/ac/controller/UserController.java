package com.ac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ac.entity.User;
import com.ac.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		
		List<User> theUsers = userService.getUsers();
		
		theModel.addAttribute("users", theUsers);
		
		return "listUsers";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		
		return "userForm";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser) {
		
		userService.saveUser(theUser);
		
		return "redirect:/user/list";
		
	}
	
	@GetMapping("/loginUser")
	public String loginUser(Model theModel, User theUser) {			
		
		String sentEmail = theUser.getEmail();
		String sentPassword = theUser.getPassword();
		
		
		List<User> theUsers = userService.getUsers();
		
		for (User temp : theUsers) {
			
			if(temp.getEmail().equals(sentEmail)) {
				if(temp.getPassword().equals(sentPassword)) {
					User tempUser = userService.getUserByEmail(sentEmail);
					theModel.addAttribute("loggedUser", tempUser);
					
					return "redirect:/user/list";
				
					
				}
			}
			
		}
		
		return "loginPage";
		
	
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int itheId, Model theModel) {
		
		User theUser = userService.getUser(itheId);
		
		theModel.addAttribute("user", theUser);
		
		return "userForm";
		
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int theId) {
		
		userService.deleteUser(theId);
		
		return "redirect:/user/list";
		
	}
	
	
	@GetMapping("/login")
	public String login(Model theModel) {
		
		List<User> theUsers = userService.getUsers();
		
		theModel.addAttribute("users", theUsers);
		
		return "loginPage";
	}
	
	@GetMapping("/signUpPage")
	public String signUpPage() {
		
		return "signUpPage";
		
	}
	
	@PostMapping("/signUpUser")
	public String signUpUser(@ModelAttribute("user") User theUser) {
		
		String sentFirstName = theUser.getFirstName();
		String sentLastName = theUser.getLastName();
		String sentEmail = theUser.getEmail();
		String sentPassword = theUser.getPassword();
		
		User temp = new User();
		temp.setFirstName(sentFirstName);
		temp.setLastName(sentLastName);
		temp.setEmail(sentEmail);
		temp.setPassword(sentPassword);
				
		userService.saveUser(temp);
								
		return "redirect:/user/list";
	
	}
	

}
