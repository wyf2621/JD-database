package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.StoreDao;
import db.dao.StoreDaoImpl;
import db.entity.Store;

public class StoreDaoImplTest {

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
		System.out.println("列出所有店铺信息");
		StoreDao dao = new StoreDaoImpl();
		List<Store> st = dao.findAll();
		for(int i = 0; i < st.size(); i++) {
			Store a = st.get(i);
			System.out.println(a.getStore_id()+" "+a.getStore_create_time()+" "+a.getStore_end_time()+" "+
							   a.getStore_introduction()+" "+a.getStore_keyword()+" "+a.getStore_license_url()+" "+
							   a.getStore_logo_url()+" "+a.getStore_name()+" "+a.getStore_pass_time()+" "+
							   a.getStore_status()+" "+a.getStore_tel()+" "+a.getStore_url()+" "+a.getStore_verifier()+" "+
							   a.getUser_user_id());
		}
		System.out.println("列出所有店铺信息成功!");
	}

	@Test
	public void testFindByUserID() {
		System.out.println("通过查找用户ID查找所有店铺信息");
		StoreDao dao = new StoreDaoImpl();
		int i=18;
		List<Store> st = dao.findByUserID(i);
		for(int j = 0; j < st.size(); j++) {
			Store a = st.get(j);
			System.out.println(a.getStore_id()+" "+a.getStore_create_time()+" "+a.getStore_end_time()+" "+
					   a.getStore_introduction()+" "+a.getStore_keyword()+" "+a.getStore_license_url()+" "+
					   a.getStore_logo_url()+" "+a.getStore_name()+" "+a.getStore_pass_time()+" "+
					   a.getStore_status()+" "+a.getStore_tel()+" "+a.getStore_url()+" "+a.getStore_verifier()+" "+
					   a.getUser_user_id());
		}
		System.out.println("查找用户ID为"+i+" 的所有店铺信息成功!");
	}

	@Test
	public void testFindByID() {
		System.out.println("通过店铺ID输出一行信息");
		StoreDao dao = new StoreDaoImpl();
		int i=13;
		Store a = dao.findByID(i);
		//测试是否找到该店铺ID
		if(a == null) {
			System.out.println("没有用户ID为 "+i+" 的店铺信息");
		}
		else {
			System.out.println("查找用户ID为"+i+" 的一行店铺信息成功!");}
	}

	@Test
	public void testSave() {
		System.out.println("增加店铺信息");
		int i=18;
		int j=19;
		StoreDao dao = new StoreDaoImpl();
		Store a1=dao.findByID(i);
		Store a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该店铺ID!");
		}
		else {
			Store st = new Store();
			st.setStore_id(i);
			st.setStore_end_time("2008-08-08 00:00:00");
			st.setStore_introduction("abc");
			st.setStore_is_direct_sale(true);
			st.setStore_keyword("abc");
			st.setStore_license_url("abc");
			st.setStore_logo_url("abc");
			st.setStore_name("name");
			st.setStore_pass_time("2008-08-08 00:00:00");
			st.setStore_create_time("2008-08-08 00:00:00");
			st.setStore_status(1);
			st.setStore_tel("123");
			st.setStore_url("abc");
			st.setStore_verifier("abc");
			st.setUser_user_id(1);
			dao.save(st);
			st.setStore_id(j);
			st.setStore_end_time("2008-08-08 00:00:00");
			st.setStore_introduction("abc");
			st.setStore_is_direct_sale(true);
			st.setStore_keyword("abc");
			st.setStore_license_url("abc");
			st.setStore_logo_url("abc");
			st.setStore_name("name");
			st.setStore_pass_time("2008-08-08 00:00:00");
			st.setStore_create_time("2008-08-08 00:00:00");
			st.setStore_status(1);
			st.setStore_tel("123");
			st.setStore_url("abc");
			st.setStore_verifier("abc");
			st.setUser_user_id(1);
			dao.save(st);
			//验证是否增加店铺信息成功
			Store a = dao.findByID(i);
			Store b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加店铺ID为 "+i+" 和 "+j+" 的店铺信息成功!");
			}
		}
	}

	@Test
	public void testDelete() {
		System.out.println("删除一行指定店铺ID信息");
		int i=19;
		StoreDao dao = new StoreDaoImpl();
		Store st= dao.findByID(i);
		if(st!=null) {
			try {
				dao.delete(st);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除店铺信息成功
		Store a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除店铺ID为 "+i+" 的店铺信息成功!");
		}
	}


	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=18;
		StoreDao dao = new StoreDaoImpl();
		Store ad=dao.findByID(i);
		//判断该店铺ID是否存在
		if(ad==null) {
			System.out.println("Find Error!");
		}
		else {
			ad.setStore_keyword("change");
			dao.update(ad);
			//验证是否更新店铺信息成功
			Store a = dao.findByID(i);
			if(!a.getStore_keyword().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新店铺ID为"+i+" 的店铺信息成功!");
		}
	}

}
