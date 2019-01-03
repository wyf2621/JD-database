package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.SkuHasOrder;

public class SkuHasOrderDaoImpl extends BaseDaoImpl implements SkuHasOrderDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public SkuHasOrder findByID(int sku_has_order_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SkuHasOrder s where s.sku_sku_id=?");
		query.setInteger(0, sku_has_order_id);
		
		List<SkuHasOrder> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<SkuHasOrder> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from SkuHasOrder");
		List<SkuHasOrder> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<SkuHasOrder> findByOrderID(int order_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SkuHasOrder s where s.order_order_id=?");
		query.setInteger(0, order_id);
		List<SkuHasOrder> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}
}
