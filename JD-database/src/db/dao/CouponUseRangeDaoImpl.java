package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.CouponUseRange;

public class CouponUseRangeDaoImpl extends BaseDaoImpl implements CouponUseRangeDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public CouponUseRange findByID(int coupon_use_range) {
		
		Session session = getSession();
		Query query = session.createQuery("from CouponUseRange c where c.coupon_use_range_id=?");
		query.setInteger(0, coupon_use_range);
		
		List<CouponUseRange> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<CouponUseRange> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from CouponUseRange");
		
		List<CouponUseRange> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<CouponUseRange> findByCouponID(int coupon_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from CouponUseRange c where c.coupon_coupon_id=?");
		query.setInteger(0, coupon_id);
		
		List<CouponUseRange> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<CouponUseRange> findByRangeID(int range_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from CouponUseRange c where c.use_range_id=?");
		query.setInteger(0, range_id);
		List<CouponUseRange> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return  list;
	}
	
}
