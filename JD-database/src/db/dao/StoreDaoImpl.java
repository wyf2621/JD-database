package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.Store;

public class StoreDaoImpl extends BaseDaoImpl implements StoreDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public List<Store> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from Store");
		List<Store> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
				
	}

	@Override
	public List<Store> findByUserID(int user_user_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Store s where s.user_user_id=?");
		query.setInteger(0, user_user_id);
		List<Store> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Store findByID(int store_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Store s where s.store_id=?");
		query.setInteger(0, store_id);
		List<Store> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}
	
	
}
