package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




import db.dao.UserInfoDao;
import db.dao.UserInfoDaoImpl;
import db.entity.UserInfo;


public class UserInfoDaoImplTest {

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
		System.out.println("列出所有用户详细信息信息");
		UserInfoDao dao = new UserInfoDaoImpl();
		List<UserInfo> userinfo = dao.findAll();
		for(int i = 0; i < userinfo.size(); i++) {
			UserInfo a = userinfo.get(i);
			System.out.println(a.getUser_info_id()+" "+a.getUser_info_birth()+" "+a.getUser_info_cost()+" "+
							   a.getUser_info_face_url()+" "+a.getUser_info_level()+" "+a.getUser_info_login_count()+" "+
							   a.getUser_info_login_time()+" "+a.getUser_info_pid()+" "+a.getUser_info_realname()+" "+
							   a.getUser_info_regist_time()+" "+a.getUser_info_return_credit()+" "+a.getUser_info_sex()+" "+
							   a.getUser_user_id());
		}
		System.out.println("列出所有用户详细信息成功!");
	}

	@Test
	public void testFindByUserID() {
		System.out.println("通过用户详细信息ID输出一行信息");
		UserInfoDao dao = new UserInfoDaoImpl();
		int i=13;
		UserInfo a = dao.findByID(i);
		//测试是否找到该用户详细信息ID
		if(a == null) {
			System.out.println("没有用户详细信息ID为 "+i+" 的详细信息");
		}
		else {
			System.out.println("查找用户详细信息ID为"+a.getUser_info_id()+" 的一行详细信息成功!");}
	}

	@Test
	public void testFindByID() {
		System.out.println("通过用户详细信息ID输出一行信息");
		UserInfoDao dao = new UserInfoDaoImpl();
		int i=13;
		UserInfo a = dao.findByID(i);
		//测试是否找到该用户详细信息ID
		if(a == null) {
			System.out.println("没有用户详细信息ID为 "+i+" 的详细信息");
		}
		else {
			System.out.println("查找用户详细信息ID为"+i+" 的一行详细信息成功!");}
	}

	@Test
	public void testSave() {
		System.out.println("增加用户详细信息");
		int i=13;
		int j=19;
		UserInfoDao dao = new UserInfoDaoImpl();
		UserInfo a1=dao.findByID(i);
		UserInfo a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该用户详细信息ID!");
		}
		else {
			UserInfo userinfo = new UserInfo();
			userinfo.setUser_info_id(i);
			userinfo.setUser_info_birth("2008-08-08 00:00:00");
			userinfo.setUser_info_cost(1);
			userinfo.setUser_info_face_url("abc");
			userinfo.setUser_info_level("abc");
			userinfo.setUser_info_login_count(1);
			userinfo.setUser_info_login_time("2008-08-08 00:00:00");
			userinfo.setUser_info_pid("abc");
			userinfo.setUser_info_realname("abc");
			userinfo.setUser_info_regist_time("2008-08-08 00:00:00");
			userinfo.setUser_info_return_credit(1);
			userinfo.setUser_info_sex("a");
			userinfo.setUser_user_id(1);
			dao.save(userinfo);
			userinfo.setUser_info_id(j);
			userinfo.setUser_info_birth("2008-08-08 00:00:00");
			userinfo.setUser_info_cost(1);
			userinfo.setUser_info_face_url("abc");
			userinfo.setUser_info_level("abc");
			userinfo.setUser_info_login_count(1);
			userinfo.setUser_info_login_time("2008-08-08 00:00:00");
			userinfo.setUser_info_pid("abc");
			userinfo.setUser_info_realname("abc");
			userinfo.setUser_info_regist_time("2008-08-08 00:00:00");
			userinfo.setUser_info_return_credit(1);
			userinfo.setUser_info_sex("a");
			userinfo.setUser_user_id(1);
			dao.save(userinfo);
			//验证是否增加用户详细信息成功
			UserInfo a = dao.findByID(i);
			UserInfo b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加用户详细信息ID为 "+i+" 和 "+j+" 的详细信息成功!");
			}
		}
	}

	@Test
	public void testDelete() {
		System.out.println("删除一行指定用户详细ID信息");
		int i=19;
		UserInfoDao dao = new UserInfoDaoImpl();
		UserInfo userinfo= dao.findByID(i);
		if(userinfo!=null) {
			try {
				dao.delete(userinfo);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除用户详细信息信息成功
		UserInfo a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除用户详细信息ID为 "+i+" 的详细信息成功!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=13;
		UserInfoDao dao = new UserInfoDaoImpl();
		UserInfo adinfo=dao.findByID(i);
		//判断该用户详细信息ID是否存在
		if(adinfo==null) {
			System.out.println("Find Error!");
		}
		else {
			adinfo.setUser_info_level("change");
			dao.update(adinfo);
			//验证是否更新用户详细信息信息成功
			UserInfo a = dao.findByID(i);
			if(!a.getUser_info_level().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新用户详细信息ID为"+i+" 的详细信息成功!");
		}
	}


}
