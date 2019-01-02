package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.Addr;

public class AddrDaoImpl extends BaseDaoImpl implements AddrDao {

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}
	
	@Override
	public Addr findByID(int addr_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Addr a where a.addr_id=?");
		query.setInteger(0, addr_id);
		List list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?(Addr)list.get(0):null;
	}

	@Override
	public List<Addr> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from Addr");
		session.beginTransaction().commit();
		session.close();
		return (List<Addr>)query.list();
	}

	@Override
	public List<Addr> findByUserID(int user_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from Addr a where a.user_user_id=?");
		query.setInteger(0, user_id);
		session.beginTransaction().commit();
		session.close();
		return (List<Addr>)query.list();
	}

}
