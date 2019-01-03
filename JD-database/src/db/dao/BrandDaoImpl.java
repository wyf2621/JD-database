package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.Brand;

public class BrandDaoImpl extends BaseDaoImpl implements BrandDao{
	
	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public Brand findByID(int brand_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Brand b where b.brand_id=?");
		query.setInteger(0, brand_id);
		List<Brand> list = query.list();
		session.beginTransaction().commit();
		session.close();
		
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<Brand> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from Brand");
		
		List<Brand> list = query.list();
		
		session.beginTransaction().commit();
		session.clear();
		return list;
	}
	
	

}
