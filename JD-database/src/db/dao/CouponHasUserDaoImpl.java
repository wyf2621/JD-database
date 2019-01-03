package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.CouponHasUser;

public class CouponHasUserDaoImpl extends BaseDaoImpl implements CouponHasUserDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public CouponHasUser findByID(int coupon_has_user_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from CouponHasUser c where c.coupon_coupon_id=?");
		query.setInteger(0, coupon_has_user_id);
		
		List<CouponHasUser> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<CouponHasUser> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from CouponHasUSer");
		
		List<CouponHasUser> list = query.list();
		session.beginTransaction().commit();
		session.cancelQuery();
		
		return list;
	}

	@Override
	public List<CouponHasUser> findByUserID(int user_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from CouponHasUser c where c.user_user_id=?");
		query.setInteger(0, user_id);
		
		List<CouponHasUser> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}
}
