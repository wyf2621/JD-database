package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.QueryExecutionRequestException;
import org.hibernate.service.ServiceRegistry;

import db.entity.Addr;
import db.entity.Advertise;

public class AdvertiseDaoImpl extends BaseDaoImpl implements AdvertiseDao {

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}
	
	@Override
	public Advertise findByID(int ad_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Advertise ad where ad.ad_id=?");
		query.setInteger(0, ad_id);
		List<Advertise> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<Advertise> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from Advertise");
		List list = (List<Advertise>)query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Advertise> findByAdType(String ad_type) {
		
		Session session = getSession();
		Query query = session.createQuery("from Advertise ad where ad.ad_type=?");
		query.setString(0, ad_type);
		List<Advertise> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}

}
