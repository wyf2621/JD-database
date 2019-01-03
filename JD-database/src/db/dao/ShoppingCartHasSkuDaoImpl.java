package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.ShoppingCartHasSku;

public class ShoppingCartHasSkuDaoImpl  extends BaseDaoImpl implements ShoppingCartHasSkuDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public ShoppingCartHasSku findByID(int shooping_cart_has_sku) {
		
		Session session = getSession();
		Query query = session.createQuery("from ShoppingCartHasSku s where s.shopping_cart_shopping_cart_id=?");
		query.setInteger(0, shooping_cart_has_sku);
		
		List<ShoppingCartHasSku> list = query.list();
		session.beginTransaction().commit();
		session.close();
		
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<ShoppingCartHasSku> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from ShoppingCartHasSku");
		
		List<ShoppingCartHasSku> list = query.list();
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}

	@Override
	public List<ShoppingCartHasSku> findBySkuID(int sku_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from ShoppingCartHasSku s where s.sku_sku_id=?");
		query.setInteger(0, sku_id);
		
		List<ShoppingCartHasSku> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}
}
