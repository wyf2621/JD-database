package db.test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.ShoppingCartDao;
import db.dao.ShoppingCartDaoImpl;
import db.entity.ShoppingCart;

public class ShoppingCartDaoImplTest {

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
	public void testGetSession() {
		
	}

	@Test
	public void testFindByID() {
		System.out.println("通过ID输出一行信息");
		ShoppingCartDao dao = new ShoppingCartDaoImpl();
		int i=13;
		ShoppingCart a = dao.findByID(i);
		if(a == null) {
			System.out.println("没有ID为 "+i+" 的信息");
		}
		else {
			System.out.println("查找ID为"+a.getShopping_cart_id()+" 的一行信息成功!");}
	
	}

	@Test
	public void testFindAll() {
		System.out.println("列出所有信息");
		ShoppingCartDao cp = new ShoppingCartDaoImpl();
		List<ShoppingCart> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			ShoppingCart a = coupon.get(i);
			System.out.println(a.getUser_user_id()+" "+a.getShopping_cart_sku_num()+" "+a.getShopping_cart_create_time()+" "+a.getUser_user_id()+" ");
		}
		System.out.println("列出所有信息成功!");
	}

	@Test
	public void testFindByUserID() {
		System.out.println("通过查找用户ID输出所有信息");
		ShoppingCartDao ad = new ShoppingCartDaoImpl();
		int i=126;
		List<ShoppingCart> addr = ad.findByUserID(i);
		for(int j = 0; j < addr.size(); j++) {
			ShoppingCart a = addr.get(j);
			System.out.println(a.getUser_user_id()+" "+a.getShopping_cart_sku_num()+" "+a.getShopping_cart_create_time()+" "+a.getUser_user_id()+" ");
		}
		System.out.println("查找用户ID为"+i+" 的所有信息成功!");
	}

	@Test
	public void testSave() {
		System.out.println("增加信息");
		ShoppingCartDao dao = new ShoppingCartDaoImpl();
		int i=13;
		int j=19;
		ShoppingCartDao br = new ShoppingCartDaoImpl();
		ShoppingCart a1 = dao.findByID(i);
		ShoppingCart a2 = dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该ID!");
		}
		else {
			ShoppingCart coupon = new ShoppingCart();
			coupon.setShopping_cart_id(i);
			coupon.setShopping_cart_create_time("2008-8-11 12:12:12");
			coupon.setShopping_cart_is_exist(true);
			coupon.setShopping_cart_sku_num(5);
			coupon.setUser_user_id(1);
			dao.save(coupon);
			coupon.setShopping_cart_id(j);
			coupon.setShopping_cart_create_time("2008-8-11 12:12:12");
			coupon.setShopping_cart_is_exist(true);
			coupon.setShopping_cart_sku_num(5);
			coupon.setUser_user_id(1);
			dao.save(coupon);
			//验证是否增加信息成功
			ShoppingCart a = dao.findByID(i);
			ShoppingCart b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加成功!");
			}
		}
	}

	@Test
	public void testDelete() {
		System.out.println("更新一行信息某列元素");
		int i=13;
		ShoppingCartDao dao = new ShoppingCartDaoImpl();
		ShoppingCart coupon=dao.findByID(i);
		//判断该ID是否存在
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setShopping_cart_is_exist(false);
			dao.update(coupon);
			//验证是否更新信息成功
			ShoppingCart a = dao.findByID(i);
			if(a.isShopping_cart_is_exist()==false) {
				System.out.println("Update Error!");
			}
			System.out.println("更新成功!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("删除一行指定ID信息");
		int i=19;
		ShoppingCartDao dao = new ShoppingCartDaoImpl();
		ShoppingCart coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除成功
		ShoppingCart a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除成功!");
		}
	}

}
