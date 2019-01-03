package db.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import db.entity.User;

public interface UserDao extends BaseDao{

	public List<User> findAll();
	
	public User findByID(int user_id);

}
