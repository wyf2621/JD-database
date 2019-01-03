package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.ShoppingCart;

public class ShoppingCartDaoImpl extends BaseDaoImpl implements ShoppingCartDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public ShoppingCart findByID(int shoppingcart_id) {
		
		Session session = getSession();
		Query query = session.createQuery("form ShoppingCart s where s.shopping_cart_id=?");
		query.setInteger(0, shoppingcart_id);
		
		List<ShoppingCart> list = query.list();
		session.beginTransaction().commit();
		session.close();
		
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<ShoppingCart> findAll() {
		
		Session session  = getSession();
		Query query = session.createQuery("from ShoppingCart");
		
		List<ShoppingCart> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<ShoppingCart> findByUserID(int user_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from ShoppingCart s where s.user_user_id=?");
		query.setInteger(0, user_id);
		
		List<ShoppingCart> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}
	
	
}
