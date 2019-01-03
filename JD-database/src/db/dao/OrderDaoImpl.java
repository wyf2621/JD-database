package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.Order;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public Order findByID(int order_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Order o where o.order_id=?");
		query.setInteger(0, order_id);
		
		List<Order> list = query.list();
		session.beginTransaction().commit();
		session.close();
		
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<Order> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from Order");
		List<Order> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Order> findByUserID(int user_id) {
		
		Session session =  getSession();
		Query query = session.createQuery("from Order o where o.user_user_id=?");
		query.setInteger(0, user_id);
		List<Order> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list;
				
	}
}
