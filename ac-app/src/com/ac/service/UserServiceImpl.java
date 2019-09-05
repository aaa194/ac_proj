package com.ac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ac.dao.UserDAOImpl;
import com.ac.entity.User;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDAOImpl userDAO;
	
	@Transactional
	public List<User> getUsers() {
		
		return userDAO.getUsers();
		
	}

	@Transactional
	public void saveUser(User theUser) {
		
		userDAO.saveUser(theUser);
		
	}

	@Transactional
	public User getUser(int itheId) {

			return userDAO.getUser(itheId);
	}

	@Transactional
	public void deleteUser(int theId) {
		
		userDAO.deleteUser(theId);
		
	}
	
	@Transactional
	public User getUserByEmail(String sentEmail) {

		return userDAO.getUserByEmail(sentEmail);
		
	}

}
