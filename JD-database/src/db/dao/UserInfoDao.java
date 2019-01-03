package db.dao;

import java.util.List;

import db.entity.UserInfo;

public interface UserInfoDao extends BaseDao{

	public List<UserInfo> findAll();
	
	public List<UserInfo> findByUserID(int user_user_id);
	
	public UserInfo findByID(int user_info_id);
	
}
