package com.niit.collaborationbackend.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.User;
//@Repository("userDAOImpl")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void addUser(User u) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
	}
	@Transactional
	public User getUserByUserId(int id)
		{
			Session session = sessionFactory.getCurrentSession();		
//			System.out.print(id);
			User u = (User) session.load(User.class, new Integer(id));
			System.out.println("get user by id :" + u);
			//session.close();
			return u;
		}
	@Transactional
		 public List<User> getAllUsers() {
		        Session session = sessionFactory.openSession();
		        Query query = session.createQuery("from User");
		        @SuppressWarnings("unchecked")
				List<User> usersDetail = query.list();

		        return usersDetail;
		    }

		    @SuppressWarnings("deprecation")
			public User getUserByUsername (String username) {
		        Session session = sessionFactory.openSession();
		        
		        Query query = session.createQuery("from User where username = ?");
		        query.setString(0, username);

		        return (User) query.uniqueResult();
		    }
		
	}		

