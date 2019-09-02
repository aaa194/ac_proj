package com.ac.service;

import java.util.List;

import com.ac.entity.User;

public interface UserService {
	
	//return list of all users in database
	public List<User> getUsers();

	//save user in database
	public void saveUser(User theUser);

	//get user with that id
	public User getUser(int itheId);

	//delete user
	public void deleteUser(int theId);

	//get user with that email
	public User getUserByEmail(String sentEmail);

}
