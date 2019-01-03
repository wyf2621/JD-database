package db.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.Return;

public class ReturnDaoImpl extends BaseDaoImpl implements ReturnDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public Return findByID(int return_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Return r where r.return_id=?");
		query.setInteger(0, return_id);
		
		List<Return> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<Return> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from Return");
		List<Return> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Return> findByUserID(int user_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Return r where r.user_user_id=?");
		query.setInteger(0, user_id);
		List<Return> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Return> findByOrderID(int order_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Return r where r.order_order_id=?");
		query.setInteger(0, order_id);
		
		List<Return> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}
	
}
