package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.Spu;

public class SpuDaoImpl extends BaseDaoImpl  implements SpuDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public List<Spu> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from Spu");
		
		List<Spu> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Spu> findByStoreID(int store_store_id) {
	
		Session session = getSession();
		Query query = session.createQuery("from Spu s where s.store_store_id=?");
		query.setInteger(0, store_store_id);
		
		List<Spu> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Spu> findByBrandID(int brand_brand_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Spu s where s.brand_brand_id=?");
		query.setInteger(0, brand_brand_id);
		
		List<Spu> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Spu> findBySpuTypeID(int spu_type_spu_type_id){
		Session session = getSession();
		Query query = session.createQuery("from Spu s where s.spu_type_spu_type_id=?");
		query.setInteger(0, spu_type_spu_type_id);
		
		List<Spu> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}
	@Override
	public Spu findByID(int spu_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Spu s where s.spu_id=?");
		query.setInteger(0, spu_id);
		
		List<Spu> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}
}
