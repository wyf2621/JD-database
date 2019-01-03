package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public List<User> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from User");
		
		List<User> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public User findByID(int user_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from User u  where u.user_id=?");
		query.setInteger(0, user_id);
		List<User> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}
}
