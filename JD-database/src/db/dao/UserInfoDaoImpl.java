package db.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.UserInfo;

public class UserInfoDaoImpl extends BaseDaoImpl implements UserInfoDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public List<UserInfo> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from UserInfo");
		List<UserInfo> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<UserInfo> findByUserID(int user_user_id) {

		Session session = getSession();
		Query query = session.createQuery("from UserInfo u where u.user_user_id=?");
		query.setInteger(0, user_user_id);
		List<UserInfo> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public UserInfo findByID(int user_info_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from UserInfo u where u.user_info_id=?");
		query.setInteger(0, user_info_id);
		List<UserInfo> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}
}
