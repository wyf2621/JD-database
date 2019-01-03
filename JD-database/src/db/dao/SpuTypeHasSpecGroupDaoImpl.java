package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.SpuTypeHasSpecGroup;

public class SpuTypeHasSpecGroupDaoImpl extends BaseDaoImpl implements SpuTypeHasSpecGroupDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public List<SpuTypeHasSpecGroup> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from SpuTypeHasSpecGroup");
		List<SpuTypeHasSpecGroup> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<SpuTypeHasSpecGroup> findGroupID(int spec_group_spec_group_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SpuTypeHasSpecGroup s where s.spec_group_spec_group_id=?");
		query.setInteger(0, spec_group_spec_group_id);
		
		List<SpuTypeHasSpecGroup> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}

	@Override
	public SpuTypeHasSpecGroup findByID(int spu_type_spu_type_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SpuTypeHasSpecGroup s where s.spu_type_spu_type_id=?");
		query.setInteger(0, spu_type_spu_type_id);
		
		List<SpuTypeHasSpecGroup> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list.size()>0?list.get(0):null;
	}
}
