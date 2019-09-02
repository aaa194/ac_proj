package com.ac.service;

import java.util.List;

import com.ac.entity.User;

public interface UserService {
	
	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int itheId);

	public void deleteUser(int theId);

	public User getUserByEmail(String sentEmail);

}
