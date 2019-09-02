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
import com.ac.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// need to inject customer service
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		
		// get customer from the service
		List<User> theUsers = userService.getUsers();
		
		// add the customer to the model
		theModel.addAttribute("users", theUsers);
		
		//front page with list of all users
		return "list-users";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		
		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser) {
		
		//System.out.println("Customer je: " + theCustomer);
		
		//save the user using our service
		userService.saveUser(theUser);
		
		
		return "redirect:/user/list";
		
	}
	
	
	@GetMapping("/loginUser")
	public String loginUser(Model model, User user) {
		
		
		
		loginUser(user, model);
		
		return "redirect:/user/list";
		
	
	}
	
	@PostMapping("/loginUser")
	public String loginUser(@ModelAttribute("user") User theUser, Model theModel) {
	
		String loggedEmail = theUser.getEmail();
		User loggedCustomer = userService.getUserByEmail(loggedEmail);
		System.out.println("ULOGOVANI User JE: " + loggedCustomer);
		
		
		String sentEmail = theUser.getEmail();
		String sentPassword = theUser.getPassword();
		
		User tempUser = userService.getUserByEmail(sentEmail);
		
		
		//System.out.println("User je: " + tempCustomer);
		
		List<User> theUsers = userService.getUsers();
		
		for (User temp : theUsers) {
			
			if(temp.getEmail().equals(sentEmail)) {
				if(temp.getPassword().equals(sentPassword)) {
					System.out.println("Successfully logged!!");
					
					theModel.addAttribute("loggedUser", tempUser);
					
					return "redirect:/user/list";
					
				}
			}else {
				
			}
			
		}
		
		System.out.println("WRONGGGGG!!! Wrong email or password!");
		return "redirect:/customer/login";
		
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int itheId, Model theModel) {
		
		//get the cust from the service
		User theUser = userService.getUser(itheId);
		
		//set cust as model attribute to pre-populate the form
		theModel.addAttribute("user", theUser);
		
		//send over to our form
		return "user-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int theId) {
		
		//delete the user
		userService.deleteUser(theId);
		
		return "redirect:/user/list";
		
	}
	
	@GetMapping("/login")
	public String login(Model theModel) {
		
		// get customer from the service
		List<User> theUsers = userService.getUsers();
		
		// add the customer to the model
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
		
		//System.out.println("Customer koji se SignUpuje: " + temp);
		
		//save the customer using our service
		userService.saveUser(temp);
								
		return "redirect:/user/list";
		
		
	}
	

}
