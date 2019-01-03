package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.SpuType;

public class SpuTypeDaoImpl extends BaseDaoImpl implements SpuTypeDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public SpuType findByID(int spu_type_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SpuType s where s.spu_type_id=?");
		
		query.setInteger(0, spu_type_id);
		List<SpuType> list = query.list();
		session.beginTransaction().commit();
		session.close();
		
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<SpuType> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from SpuType");
		
		List<SpuType> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
		
	}

	@Override
	public List<SpuType> findByFatherID(int spu_type_father_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SpuType s where s.spu_type_father_id=?");
		query.setInteger(0, spu_type_father_id);
		
		List<SpuType> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
		
	}

}
