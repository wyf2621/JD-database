package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.Advertise;
import db.entity.AdvertiseInfo;

public class AdvertiseInfoDaoImpl extends BaseDaoImpl implements AdvertiseInfoDao {

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}
	
	@Override
	public AdvertiseInfo findByID(int ad_info_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from AdvertiseInfo ad where ad.ad_info_id=?");
		query.setInteger(0, ad_info_id);
		List<AdvertiseInfo> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list.size()>0?list.get(0):null;	
	}

	@Override
	public List<AdvertiseInfo> findAll() {
		Session session = getSession();
		Query query = session.createQuery("from AdvertiseInfo");
		
		return (List<AdvertiseInfo>)query.list();
	}

	@Override
	public List<AdvertiseInfo> findByStoreID(int store_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from AdvertiseInfo ad where ad.store_store_id=?");
		query.setInteger(0, store_id);
		List<AdvertiseInfo> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}

	@Override
	public List<AdvertiseInfo> findByAdID(int ad_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from AdvertiseInfo ad where ad.advertise_ad_id=?");
		query.setInteger(0, ad_id);
		List<AdvertiseInfo> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		
		return list;
	}

}
