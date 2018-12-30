package db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.UserInfo;


public class BaseDaoImpl implements BaseDao{
	
	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public void save(Object obj) {
		Session session = getSession();
		session.save(obj);
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Object obj) {
		Session session = getSession();
		session.delete(obj);
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public void update(Object obj) {
		Session session = getSession();
		session.update(obj);
		session.beginTransaction().commit();
		session.close();
	}
	
}
