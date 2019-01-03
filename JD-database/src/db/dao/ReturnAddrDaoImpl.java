package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.ReturnAddr;

public class ReturnAddrDaoImpl extends BaseDaoImpl implements ReturnAddrDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public ReturnAddr findByID(int return_addr_id) {
		
		Session session  = getSession();
		Query query = session.createQuery("from ReturnAddr r where r.return_addr_id=?");
		query.setInteger(0, return_addr_id);
		
		List<ReturnAddr> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<ReturnAddr> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from ReturnAddr");
		List<ReturnAddr> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<ReturnAddr> findByStoreID(int store_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from ReturnAddr r where r.return_addr_id=?");
		query.setInteger(0, store_id);
		List<ReturnAddr> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}
	
}
