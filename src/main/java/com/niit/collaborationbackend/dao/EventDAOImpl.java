package com.niit.collaborationbackend.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationbackend.model.Event;
@Repository("EventDAO")
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void addEvent(Event e) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		session.close();
	}
	@Transactional
	public Event getEventByEventId(int id)
		{
			Session session = sessionFactory.openSession();		
//			System.out.print(id);
			Event e = (Event) session.load(Event.class, new Integer(id));
			session.close();
			return e;
		}
	@Transactional
		 public List<Event> getAllEvents() {
		        Session session = sessionFactory.openSession();
		        Query query = session.createQuery("from Event");
		        @SuppressWarnings("unchecked")
				List<Event> EventsDetail = query.list();

		        return EventsDetail;
		    }

		    public Event getEventByEventname (String Eventname) {
		        Session session = sessionFactory.openSession();
		        
		        Query query = session.createQuery("from Event where Eventname = ?");
		        query.setString(0, Eventname);

		        return (Event) query.uniqueResult();
		    }


	}		

