package db.test;

import db.dao.BaseDao;
import db.dao.BaseDaoImpl;
import db.entity.User;

public class Test{
	void testSave() {
		BaseDaoImpl dao = new BaseDaoImpl();
		User user = new User();
		user.setUser_id(123);
		user.setUser_password("123");
		dao.save(user);
	}
}