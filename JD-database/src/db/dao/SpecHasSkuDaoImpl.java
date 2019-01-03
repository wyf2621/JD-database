package db.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.Spec;
import db.entity.SpecHasSku;

public class SpecHasSkuDaoImpl extends BaseDaoImpl implements SpecHasSkuDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public SpecHasSku findByID(int spec_spec_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SpecHasSku s where s.spec_spec_id=?");
		query.setInteger(0, spec_spec_id);
		
		List<SpecHasSku> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<SpecHasSku> findBySkuID(int sku_sku_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SpecHasSku s where s.sku_sku_id=?");
		query.setInteger(0, sku_sku_id);
		
		List<SpecHasSku> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<SpecHasSku> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from SpecHasSku");
		List<SpecHasSku> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}
	
}
