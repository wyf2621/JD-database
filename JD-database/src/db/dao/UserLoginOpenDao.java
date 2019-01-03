package db.dao;

import java.util.List;

import db.entity.UserLoginOpen;

public interface UserLoginOpenDao extends BaseDao{

	public List<UserLoginOpen> findAll();
	
	public List<UserLoginOpen> findByUserID(int user_user_id);
	
	public UserLoginOpen findByID(int user_login_open_id);
}
