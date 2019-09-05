package com.ac.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ac.entity.User;

@Repository
public class UserDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<User> getUsers() {

		Session curentSession = sessionFactory.getCurrentSession();
		
		Query<User> theQuery = curentSession.createQuery("from User order by lastName", User.class);
		
		List<User> users = theQuery.getResultList();
		
		return users;
		
	}

	public void saveUser(User theUser) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theUser);

	}

	public User getUser(int itheId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		User theUser = currentSession.get(User.class, itheId);
		
		return theUser;
	}

	public void deleteUser(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> theQuery = currentSession.createQuery("delete from User where id=:userId");
		
		theQuery.setParameter("userId", theId);
		
		theQuery.executeUpdate();

	}
	
	public User getUserByEmail(String sentEmail) {
		
		Session curentSession = sessionFactory.getCurrentSession();
				
		Query<User> theQuery = curentSession.createQuery("from User where email = \'" + sentEmail + "\' order by lastName", User.class);
				
		User user = theQuery.getSingleResult();
				
		return user;
	}

}
