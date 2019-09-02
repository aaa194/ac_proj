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
	
	// need to inject user service
	@Autowired
	private UserService userService;
	
	//List all users
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		
		// get user from the service
		List<User> theUsers = userService.getUsers();
		
		// add the user to the model
		theModel.addAttribute("users", theUsers);
		
		//front page with list of all users
		return "list-users";
		
	}
	
	//Form for adding new user
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		
		return "user-form";
	}
	
	//Saving user to the database
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser) {
		
		//System.out.println("User je: " + theUser);
		
		//save the user using our service
		userService.saveUser(theUser);
		
		
		return "redirect:/user/list";
		
	}
	
	//
	@GetMapping("/loginUser")
	public String loginUser(Model model, User user) {
		
		
		
		loginUser(user, model);
		
		return "redirect:/user/list";
		
	
	}
	
	//Login user, checking if credentials are ok
	@PostMapping("/loginUser")
	public String loginUser(@ModelAttribute("user") User theUser, Model theModel) {
	
		String loggedEmail = theUser.getEmail();
		User loggedUser = userService.getUserByEmail(loggedEmail);
		System.out.println("ULOGOVANI User JE: " + loggedUser);
		
		
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
	
	//Form for updating user
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int itheId, Model theModel) {
		
		//get the user from the service
		User theUser = userService.getUser(itheId);
		
		//set user as model attribute to pre-populate the form
		theModel.addAttribute("user", theUser);
		
		//send over to our form
		return "user-form";
		
	}
	
	//Deleting user from database
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
	
	//get the sign up page
	@GetMapping("/signUpPage")
	public String signUpPage() {
		
		return "signUpPage";
		
	}
	
	//Creating new user
	@PostMapping("/signUpUser")
	public String signUpUser(@ModelAttribute("user") User theUser) {
		
		//gather the info that customer input
		String sentFirstName = theUser.getFirstName();
		String sentLastName = theUser.getLastName();
		String sentEmail = theUser.getEmail();
		String sentPassword = theUser.getPassword();
		
		//create USER with that input in database
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
