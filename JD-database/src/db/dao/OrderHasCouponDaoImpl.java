package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.OrderHasCoupon;

public class OrderHasCouponDaoImpl extends BaseDaoImpl implements OrderHasCouponDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public List<OrderHasCoupon> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from OrderHasCoupon");
		List<OrderHasCoupon> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public OrderHasCoupon findByID(int order_has_coupon_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from OrderHasCoupon o where o.order_order_id=?");
		query.setInteger(0, order_has_coupon_id);
		
		List<OrderHasCoupon> list =  query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
		
		
	}

	@Override
	public List<OrderHasCoupon> findByCouponID(int coupon_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from OrderHasCoupon o where o.coupon_coupon_id=?");
		query.setInteger(0, coupon_id);
		
		List<OrderHasCoupon> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}
}
