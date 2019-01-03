package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.Coupon;

public class CouponDaoImpl extends BaseDaoImpl implements CouponDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public Coupon findByID(int coupon_id) {
		
		Session  session = getSession();
		Query query = session.createQuery("from Coupon c where c.coupon_id=?");
		query.setInteger(0, coupon_id);
		
		List<Coupon> list = query.list();
		session.beginTransaction().commit();
		session.close();
		
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<Coupon> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from Coupon");
		List<Coupon> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}

	@Override
	public List<Coupon> findByUserType(String user_lever) {
		
		Session session = getSession();
		Query query = session.createQuery("from Coupon c where c.coupon_user_lever");
		query.setString(0, user_lever);
		
		List<Coupon> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list;
		
	}
}
