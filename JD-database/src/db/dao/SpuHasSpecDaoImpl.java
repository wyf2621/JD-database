package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.SpuHasSpec;

public class SpuHasSpecDaoImpl extends BaseDaoImpl implements SpuHasSpecDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public List<SpuHasSpec> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from SpuHasSpec");
		List<SpuHasSpec> list =  query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}

	@Override
	public List<SpuHasSpec> findBySpecID(int spec_spec_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpuHasSpec findByID(int spu_spu_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SpuHasSpec s where s.spu_spu_id=?");
		query.setInteger(0, spu_spu_id);
		
		List<SpuHasSpec> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}

}
