package com.db;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dto.BSE;
import com.dto.Graph;
import com.dto.NSE;
import com.dto.User;


public class Hibernate {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static int addObject(Object obj){
		System.out.println("Inside Template...");
		int result=0;
		Transaction tx=null;	
		try {
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			session.save(obj);
			tx.commit();
			result=1;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	/*public static List getObjectListByDate(int serviceId, Date date) {
		// TODO Auto-generated method stub
		String hql = "from Book where serviceId = :serviceId and DATE_FORMAT(date,'%Y-%m-%d') = :date";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		query.setInteger("serviceId", serviceId);
		query.setDate("date", date);
		List<Company> logEntries = query.list();
		return logEntries;
	}*/

	public static User login(String email, String password) {
		String queryString = "from User where email = :email and password =:password";
		Session session=sessionFactory.openSession();
		Query query = session.createQuery(queryString);
		query.setString("email", email);
		query.setString("password", password);
		Object queryResult = query.uniqueResult();
		User user = (User)queryResult;
		return user;
	}

	public static NSE nseData(Date date) {
		// TODO Auto-generated method stub
		String queryString = "from NSE where date = :date";
		Session session=sessionFactory.openSession();
		Query query = session.createQuery(queryString);
		query.setDate("date", date);
		Object queryResult = query.uniqueResult();
		NSE user = (NSE)queryResult;
		return user;
	}
	public static BSE bseData(Date date) {
		// TODO Auto-generated method stub
		String queryString = "from BSE where date = :date";
		Session session=sessionFactory.openSession();
		Query query = session.createQuery(queryString);
		query.setDate("date", date);
		Object queryResult = query.uniqueResult();
		BSE user = (BSE)queryResult;
		return user;
	}

	public static List<Graph> graphData() {
		// TODO Auto-generated method stub
		String queryString = "date,open from RELIENCE where date>'2020-08-06' and date<'2020-08-14'";
		Session session=sessionFactory.openSession();
		Query query = session.createQuery(queryString);
		Object queryResult = query.uniqueResult();
		List<Graph> user = query.list();
		return user;
	}
	public static List<Date> graphDta() {
		// TODO Auto-generated method stub
		String queryString = "select date from RELIENCE where date>'2020-08-06' and date<'2020-08-14'";
		Session session=sessionFactory.openSession();
		Query query = session.createQuery(queryString);
		Object queryResult = query.setMaxResults(1).uniqueResult();
		List<Date> user = query.list();
		return user;
	}
}
