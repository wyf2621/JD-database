package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.AttrValue;

public class AttrValueDaoImpl extends BaseDaoImpl implements AttrValueDao{
	
	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public AttrValue findByID(int attr_value_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from AttrValue attrvalue where attrvalue.attr_value_id=?");
		query.setInteger(0, attr_value_id);
		List<AttrValue> list = query.list();
		
		session.beginTransaction().commit();
		session.clear();
		
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<AttrValue> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from AttrValue");
		
		List<AttrValue> list = query.list();
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}

	@Override
	public List<AttrValue> findByAttrID(int attr_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from AttrValue attrvalue where attrvalue.attr_attr_id=?");
		query.setInteger(0, attr_id);
		
		List<AttrValue> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

}
