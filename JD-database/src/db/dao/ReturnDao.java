package db.dao;

import java.util.List;

import db.entity.Return;

public interface ReturnDao {

	public Return findByID(int return_id);
	
	public List<Return> findAll();
	
	public List<Return> findByUserID(int user_id);
	
	public List<Return> findByOrderID(int order_id);
}
