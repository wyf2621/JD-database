package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import antlr.collections.impl.LList;
import db.entity.Spu;
import db.entity.SpuTypeHasStoreInfo;

public class SpuTypeHasStoreInfoDaoImpl extends BaseDaoImpl implements SpuTypeHasStoreInfoDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public List<SpuTypeHasStoreInfo> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from SpuTypeHasStoreInfo");
		List<SpuTypeHasStoreInfo> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}

	@Override
	public List<SpuTypeHasStoreInfo> findByStoreID(int spec_info_store_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SpuTypeHasStoreInfo s where s.spec_info_store_id=?");
		query.setInteger(0, spec_info_store_id);
		
		List<SpuTypeHasStoreInfo> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public SpuTypeHasStoreInfo findByID(int spu_type_spu_type_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from SpuTypeHasStoreInfo s where s.spu_type_spu_type_id=?");
		query.setInteger(0,spu_type_spu_type_id);
		
		List<SpuTypeHasStoreInfo> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
		
	}
	
	
}
