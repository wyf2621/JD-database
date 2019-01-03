package db.dao;

import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.UserLoginOpen;

public class UserLoginOpenDaoImpl extends BaseDaoImpl implements UserLoginOpenDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public List<UserLoginOpen> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from UserLoginOpen");
		
		List<UserLoginOpen> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<UserLoginOpen> findByUserID(int user_user_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from UserLoginOpen u where u.user_user_id=?");
		query.setInteger(0, user_user_id);
		
		List<UserLoginOpen> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public UserLoginOpen findByID(int user_login_open_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from UserLoginOpen u where u.user_login_open_id=?");
		query.setInteger(0, user_login_open_id);
		
		List<UserLoginOpen> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}
}
