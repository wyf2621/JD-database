package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.Sku;
import db.entity.SkuHasReturn;

public class SkuHasReturnDaoImpl extends BaseDaoImpl implements SkuHasReturnDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}
	
	@Override
	public SkuHasReturn findByID(int sku_has_return_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SkuHasReturn s where s.sku_sku_id=?");
		query.setInteger(0, sku_has_return_id);
		
		List<SkuHasReturn> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<SkuHasReturn> findAll() {
	
		Session session = getSession();
		Query query = session.createQuery("from SkuHasReturn");
		
		List<SkuHasReturn> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<SkuHasReturn> findByReturnID(int return_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SkuHasReturn s where s.return_return_id=?");
		query.setInteger(0, return_id);
		
		List<SkuHasReturn> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

}
