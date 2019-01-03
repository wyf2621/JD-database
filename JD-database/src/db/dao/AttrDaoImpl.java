package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.Attr;

public class AttrDaoImpl extends BaseDaoImpl implements AttrDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}
	
	@Override
	public List<Attr> findAll() {
		Session session = getSession();
		Query query = session.createQuery("from Attr");
		
		List list = (List<Attr>)query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Attr findByID(int attr_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Attr attr where attr.attr_id=?");
		query.setInteger(0, attr_id);
		List<Attr> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list.size()>0?list.get(0):null;	
	}

	
}
