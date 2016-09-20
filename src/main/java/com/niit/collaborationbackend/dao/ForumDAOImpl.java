package com.niit.collaborationbackend.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationbackend.model.Forum;
@Repository("ForumDAO")
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void addForum(Forum f) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(f);
		tx.commit();
		session.close();
	}
	@Transactional
	public Forum getForumByForumId(int id)
		{
			Session session = sessionFactory.openSession();		
//			System.out.print(id);
			Forum f = (Forum) session.load(Forum.class, new Integer(id));
			session.close();
			return f;
		}
	@Transactional
		 public List<Forum> getAllForums() {
		        Session session = sessionFactory.openSession();
		        Query query = session.createQuery("from Forum");
		        @SuppressWarnings("unchecked")
				List<Forum> ForumsDetail = query.list();

		        return ForumsDetail;
		    }

		    public Forum getForumByForumname (String Forumname) {
		        Session session = sessionFactory.openSession();
		        
		        Query query = session.createQuery("from Forum where Forumname = ?");
		        query.setString(0, Forumname);

		        return (Forum) query.uniqueResult();
		    }


	}		

