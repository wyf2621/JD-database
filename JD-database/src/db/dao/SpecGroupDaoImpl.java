package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.SpecGroup;

public class SpecGroupDaoImpl extends BaseDaoImpl implements SpecGroupDao{
	
	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public SpecGroup findByID(int spec_group_id) {
		
		Session session = getSession();
		Query  query = session.createQuery("from SpecGrroup s where s.spec_group_id=?");
		query.setInteger(0, spec_group_id);
		
		List<SpecGroup> list = query.list();
		session.beginTransaction().commit();
		session.close();
		
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<SpecGroup> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from SpecGroup");
		
		List<SpecGroup> list = query.list();
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}

}
