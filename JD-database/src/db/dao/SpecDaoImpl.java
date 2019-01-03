package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cache.spi.GeneralDataRegion;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.mchange.util.Queue;

import db.entity.Spec;

public class SpecDaoImpl extends BaseDaoImpl implements SpecDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public Spec findByID(int spec_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Spec s where s.spec_id=?");
		query.setInteger(0, spec_id);
		
		List<Spec> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<Spec> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from Spec");
		
		List<Spec> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Spec> findByGroupID(int group_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Spec s where s.spec_group_spec_group_id=?");
		query.setInteger(0, group_id);
		
		List<Spec> list = query.list();
		session.beginTransaction().commit();
		return list;
	}
}
