package db.test;


import db.dao.BaseDao;
import db.dao.BaseDaoImpl;
import db.entity.User;

class TestDao {
	public static void main(String [] args){
		BaseDaoImpl dao = new BaseDaoImpl();
		User user = new User();
		user.setUser_id(124);
		user.setUser_password("124");
		user.setUser_username("sdad");
		user.setUser_email("aa");
		user.setUser_tel("89998");
		user.setUser_status(0);
		dao.delete(user);
		
	}

}
