package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.AttrValue;
import db.entity.AttrValueHasSku;

public class AttrValueHasSkuDaoImpl extends BaseDaoImpl implements AttrValueHasSkuDao{
	
	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public AttrValueHasSku findByID(int attr_value_has_sku_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from AttrValueHasValue attrvalue where attrvalue.attr_value_attr_value_id=?");
		query.setInteger(0, attr_value_has_sku_id);
		List<AttrValueHasSku> list = query.list();
		
		session.beginTransaction().commit();
		session.clear();
		
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<AttrValueHasSku> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from AttrValueHasSku");
		
		List<AttrValueHasSku> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}

	@Override
	public List<AttrValueHasSku> findBySkuID(int sku_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from AttrValueHasSku a where a.sku_sku_id=?");
		query.setInteger(0, sku_id);
		
		List<AttrValueHasSku> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}

	
}
