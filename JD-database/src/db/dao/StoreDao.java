package db.dao;

import java.util.List;

import db.entity.Store;

public interface StoreDao extends BaseDao{

	public List<Store> findAll();
	
	public List<Store> findByUserID(int user_user_id);
	
	public Store findByID(int store_id);
}
