package com.niit.collaborationbackend.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationbackend.model.User;
@Repository("userDAO")
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
			Session session = sessionFactory.openSession();		
//			System.out.print(id);
			User u = (User) session.load(User.class, new Integer(id));
			session.close();
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

		    public User getUserByUsername (String username) {
		        Session session = sessionFactory.openSession();
		        
		        Query query = session.createQuery("from User where username = ?");
		        query.setString(0, username);

		        return (User) query.uniqueResult();
		    }


	}		
