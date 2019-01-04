package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.UserLoginOpenDao;
import db.dao.UserLoginOpenDaoImpl;
import db.entity.UserLoginOpen;


public class UserLoginOpenDaoImplTest {

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
		System.out.println("列出所有用户登录信息");
		 UserLoginOpenDao dao = new  UserLoginOpenDaoImpl();
		List< UserLoginOpen> ad = dao.findAll();
		for(int i = 0; i < ad.size(); i++) {
			UserLoginOpen a = ad.get(i);
			System.out.println(a.getUser_login_open_id()+" "+a.getUser_login_open_qq_no()+" "+a.getUser_login_open_wechat_no()+" "+
							   a.getUser_user_id());
		}
		System.out.println("列出所有用户登录信息成功!");
	}

	@Test
	public void testFindByUserID() {
		System.out.println("通过查找用户ID输出所有用户登录信息");
		UserLoginOpenDao dao = new  UserLoginOpenDaoImpl();
		int i=18;
		List< UserLoginOpen> ad = dao.findByUserID(i);
		for(int j = 0; j < ad.size(); j++) {
			UserLoginOpen a = ad.get(j);
			System.out.println(a.getUser_login_open_id()+" "+a.getUser_login_open_qq_no()+" "+a.getUser_login_open_wechat_no()+" "+
					   a.getUser_user_id());
		}
		System.out.println("查找用户ID为"+i+" 的所有用户登录信息成功!");
	}

	@Test
	public void testFindByID() {
		System.out.println("通过用户ID输出一行信息");
		UserLoginOpenDao dao = new UserLoginOpenDaoImpl();
		int i=13;
		UserLoginOpen a = dao.findByID(i);
		//测试是否找到该用户ID
		if(a == null) {
			System.out.println("没有用户ID为 "+i+" 的登录信息");
		}
		else {
			System.out.println("查找用户ID为"+i+" 的一行登录信息成功!");}
	}

	@Test
	public void testSave() {
		System.out.println("增加用户登录信息");
		int i=13;
		int j=19;
		UserLoginOpenDao dao = new UserLoginOpenDaoImpl();
		UserLoginOpen a1=dao.findByID(i);
		UserLoginOpen a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该用户登录ID!");
		}
		else {
			UserLoginOpen ad = new UserLoginOpen();
			ad.setUser_login_open_id(i);
			ad.setUser_login_open_qq_no("abc");
			ad.setUser_login_open_wechat_no("abc");
			ad.setUser_user_id(i);
			dao.save(ad);
			ad.setUser_login_open_id(j);
			ad.setUser_login_open_qq_no("abc");
			ad.setUser_login_open_wechat_no("abc");
			ad.setUser_user_id(j);
			//验证是否增加用户登录信息成功
			UserLoginOpen a = dao.findByID(i);
			UserLoginOpen b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加用户登录ID为 "+i+" 和 "+j+" 的广告登录信息成功!");
			}
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=13;
		UserLoginOpenDao dao = new UserLoginOpenDaoImpl();
		UserLoginOpen ad=dao.findByID(i);
		//判断该用户登录ID是否存在
		if(ad==null) {
			System.out.println("Find Error!");
		}
		else {
			ad.setUser_login_open_qq_no("change");
			dao.update(ad);
			//验证是否更新用户登录信息成功
			UserLoginOpen a = dao.findByID(i);
			if(!a.getUser_login_open_qq_no().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新用户登录ID为"+i+" 的信息成功!");
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("删除一行指定用户登录ID信息");
		int i=19;
		UserLoginOpenDao dao = new UserLoginOpenDaoImpl();
		UserLoginOpen ad= dao.findByID(i);
		if(ad!=null) {
			try {
				dao.delete(ad);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除用户登录信息成功
		UserLoginOpen a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除用户登录ID为 "+i+" 的信息成功!");
		}
	}
}
