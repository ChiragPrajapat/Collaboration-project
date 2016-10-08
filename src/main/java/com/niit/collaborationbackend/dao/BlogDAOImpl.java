package com.niit.collaborationbackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationbackend.model.Blog;

@Repository("BlogDAO")
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addBlog(Blog blog) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(blog);
		tx.commit();
		session.close();
	}

	@Transactional
	public Blog getBlogByBlogId(int id) {
		Session session = sessionFactory.openSession();
		// System.out.print(id);
		Blog b = (Blog) session.load(Blog.class, new Integer(id));
		session.close();
		return b;
	}

	@Transactional
	public List<Blog> getAllBlogs() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Blog");
		@SuppressWarnings("unchecked")
		List<Blog> BlogsDetail = query.list();

		return BlogsDetail;
	}

	@Transactional
	public Blog getBlogByBlogname(String Title) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Blog where Title = ?");
		query.setString(0, Title);

		return (Blog) query.uniqueResult();
	}

	@Transactional
	public void DeleteBlog(Blog blog) {
		Session session = sessionFactory.openSession();
		session.delete(blog);
		session.close();
	}
}
