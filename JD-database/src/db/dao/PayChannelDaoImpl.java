package db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.PayChannel;

public class PayChannelDaoImpl extends BaseDaoImpl implements PayChannelDao{

	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();  
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public List<PayChannel> findAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from PayChannel");
		List<PayChannel> list = query.list();
		
		session.beginTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public PayChannel findByID(int pay_channel_id) {
		
		Session session = getSession();;
		Query query = session.createQuery("from PayChannel p where p.pay_cahnnel_id=?");
		query.setInteger(0, pay_channel_id);
		
		List<PayChannel> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<PayChannel> findByUserID(int user_id) {
		
		Session session = getSession();
		Query query = session.createQuery("from PayChannel p where p.user_user_id=?");
		query.setInteger(0, user_id);
		
		List<PayChannel> list = query.list();
		session.beginTransaction().commit();
		session.close();
		return list;
	}
}
