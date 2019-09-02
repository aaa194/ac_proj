package com.ac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ac.dao.UserDAO;
import com.ac.entity.User;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	// need to inject customer dao
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		
		return userDAO.getUsers();
		
	}

	@Override
	@Transactional
	public void saveUser(User theUser) {
		
		userDAO.saveUser(theUser);
		
	}

	@Override
	@Transactional
	public User getUser(int itheId) {

			return userDAO.getUser(itheId);
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {
		
		userDAO.deleteUser(theId);
		
	}

	@Override
	@Transactional
	public User getUserByEmail(String sentEmail) {

		return userDAO.getUserByEmail(sentEmail);
		
	}

}
