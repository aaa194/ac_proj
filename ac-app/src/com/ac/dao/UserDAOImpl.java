package com.ac.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ac.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {

		//get the current hibernate session
		Session curentSession = sessionFactory.getCurrentSession();
		
		//create a query ... sort by last name
		Query<User> theQuery = curentSession.createQuery("from User order by lastName", User.class);
		
		//get the list of customers from the query
		List<User> users = theQuery.getResultList();
		
		//return the list of customers
		return users;
		
	}

	@Override
	public void saveUser(User theUser) {

		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save/update the customer ... finally 
		currentSession.saveOrUpdate(theUser);

	}

	@Override
	public User getUser(int itheId) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve from db using PK
		User theUser = currentSession.get(User.class, itheId);
		
		return theUser;
	}

	@Override
	public void deleteUser(int theId) {

		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query ... sort by last name
		Query<User> theQuery = currentSession.createQuery("delete from User where id=:userId");
		
		//customerId iz linije iznad moramo nekako dodeliti prvo u theQuery, a to radimo ovako
		theQuery.setParameter("userId", theId);
		
		theQuery.executeUpdate();

	}

	@Override
	public User getUserByEmail(String sentEmail) {
		
		//get the current hibernate session
		Session curentSession = sessionFactory.getCurrentSession();
				
		//create a query ... sort by last name
		Query<User> theQuery = curentSession.createQuery("from User where email = \'" + sentEmail + "\' order by lastName", User.class);
				
		//get the list of customers from the query
		User user = theQuery.getSingleResult();
				
		//return the list of customers
		return user;
	}

}