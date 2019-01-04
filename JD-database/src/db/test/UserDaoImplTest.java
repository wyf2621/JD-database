package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.AdvertiseInfoDao;
import db.dao.AdvertiseInfoDaoImpl;
import db.dao.UserDao;
import db.dao.UserDaoImpl;
import db.entity.AdvertiseInfo;
import db.entity.User;

public class UserDaoImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testFindAll() {
		System.out.println("列出所有用户基础信息");
		UserDao dao = new UserDaoImpl();
		List<User> user = dao.findAll();
		for(int i = 0; i < user.size(); i++) {
			User a = user.get(i);
			System.out.println(a.getUser_id()+" "+a.getUser_email()+" "+a.getUser_password()+" "+
							   a.getUser_status()+" "+a.getUser_tel()+" "+a.getUser_username());
		}
		System.out.println("列出所有用户基础信息成功!");
	}

	@Test
	public void testFindByID() {
		System.out.println("通过UserID输出一行信息");
		UserDao dao = new UserDaoImpl();
		int i=13;
		User a = dao.findByID(i);
		//测试是否找到该用户基础信息ID
		if(a == null) {
			System.out.println("没有用户基础信息ID为 "+i+" 的信息");
		}
		else {
			System.out.println("查找用户基础信息ID为"+a.getUser_id()+" 的一行信息成功!");}
	}
	

	@Test
	public void testSave() {
		System.out.println("增加用户基础信息");
		int i=13;
		int j=19;
		UserDao dao = new UserDaoImpl();
		User a1=dao.findByID(i);
		User a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该用户基础信息ID!");
		}
		else {
			User user = new User();
			user.setUser_id(i);
			user.setUser_email("abc");
			user.setUser_status(1);
			user.setUser_password("abc");
			user.setUser_tel("abc");
			user.setUser_username("abc");
			dao.save(user);
			user.setUser_id(j);
			user.setUser_email("abc");
			user.setUser_status(1);
			user.setUser_password("abc");
			user.setUser_tel("abc");
			user.setUser_username("abc");
			dao.save(user);
			//验证是否增加用户基础信息成功
			User a = dao.findByID(i);
			User b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加用户基础信息ID为 "+i+" 和 "+j+" 的信息成功!");
			}
		}
	}

	@Test
	public void testDelete() {
		System.out.println("删除一行指定广告详细ID信息");
		int i=19;
		UserDao dao = new UserDaoImpl();
		User user= dao.findByID(i);
		if(user!=null) {
			try {
				dao.delete(user);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除用户基础信息信息成功
		User a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除用户基础信息ID为 "+i+" 的信息成功!");
		}
	
	}

	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=13;
		UserDao dao = new UserDaoImpl();
		User user=dao.findByID(i);
		//判断该广告详细信息ID是否存在
		if(user==null) {
			System.out.println("Find Error!");
		}
		else {
			user.setUser_username("change");
			dao.update(user);
			//验证是否更新用户基础信息信息成功
			User a = dao.findByID(i);
			if(!a.getUser_username().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新用户基础信息ID为"+i+" 的信息成功!");
		}
	}

}
