package com.niit.collaborationbackend.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationbackend.model.Placement;
@Repository("PlacementDAO")
public class PlacementDAOImpl implements PlacementDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public PlacementDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void addPlacement(Placement u) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
	}
	@Transactional
	public Placement getPlacementByPlacementId(int id)
		{
			Session session = sessionFactory.openSession();		
//			System.out.print(id);
			Placement u = (Placement) session.load(Placement.class, new Integer(id));
			session.close();
			return u;
		}
	@Transactional
		 public List<Placement> getAllPlacements() {
		        Session session = sessionFactory.openSession();
		        Query query = session.createQuery("from Placement");
		        @SuppressWarnings("unchecked")
				List<Placement> PlacementsDetail = query.list();

		        return PlacementsDetail;
		    }

		    public Placement getPlacementByPlacementname (String company) {
		        Session session = sessionFactory.openSession();
		        
		        Query query = session.createQuery("from Placement where Company = ?");
		        query.setString(0, company);

		        return (Placement) query.uniqueResult();
		    }


	}		

