package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.Sku;

public class SkuDaoImpl extends BaseDaoImpl implements SkuDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public Sku findByID(int sku_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Sku s where s.sku_id=?");
		query.setInteger(0, sku_id);
		 List<Sku> list = query.list();
		 
		 session.beginTransaction().commit();
		 session.close();
		 return list.size()>0?list.get(0):null;
 	}

	@Override
	public List<Sku> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from Sku");
		List<Sku> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Sku> findBySpuID(int spu_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Sku s where s.spu_spu_id=?");
		query.setInteger(0, spu_id);
		
		List<Sku> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}
	
	@Override
	public List<Sku> findBySpecID(int spec_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Sku s where s.spec_spec_id=?");
		query.setInteger(0, spec_id);
		
		List<Sku> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}
	
}
