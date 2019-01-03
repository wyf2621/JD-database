package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.CouponDao;
import db.dao.CouponDaoImpl;
import db.entity.Coupon;



public class CouponDaoImplTest {

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
		CouponDao dao = new CouponDaoImpl();
		int i=13;
		Coupon a = dao.findByID(i);
		if(a == null) {
			System.out.println("没有ID为 "+i+" 的信息");
		}
		else {
			System.out.println("查找ID为"+a.getCoupon_id()+" 的一行信息成功!");}
	}

	@Test
	public void testSave() {
		System.out.println("增加信息");
		CouponDao dao = new CouponDaoImpl();
		int i=13;
		int j=19;
		CouponDao br = new CouponDaoImpl();
		Coupon a1 = dao.findByID(i);
		Coupon a2 = dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该ID!");
		}
		else {
			Coupon coupon = new Coupon();
			coupon.setCoupon_id(i);
			coupon.setCoupon_begin_time("2008-08-11 12:21:12");
			coupon.setCoupon_cost_allocation(123);
			coupon.setCoupon_end_time("2019-09-11 12:00:00");
			coupon.setCoupon_how_many(123);
			coupon.setCoupon_is_deleted(false);
			coupon.setCoupon_lower_bound(123);
			coupon.setCoupon_name("4132421");
			coupon.setCoupon_note("dfghjk");
			coupon.setCoupon_type(3);
			coupon.setCoupon_user_lever("high");
			coupon.setCoupon_user_range(2);
			coupon.setCoupon_value(21);
			coupon.setCoupon_verifier("as");
			dao.save(coupon);
			coupon.setCoupon_id(i);
			coupon.setCoupon_begin_time("2008-08-11 12:21:12");
			coupon.setCoupon_cost_allocation(123);
			coupon.setCoupon_end_time("2019-09-11 12:00:00");
			coupon.setCoupon_how_many(123);
			coupon.setCoupon_is_deleted(false);
			coupon.setCoupon_lower_bound(123);
			coupon.setCoupon_name("4132421");
			coupon.setCoupon_note("dfghjk");
			coupon.setCoupon_type(3);
			coupon.setCoupon_user_lever("high");
			coupon.setCoupon_user_range(2);
			coupon.setCoupon_value(21);
			coupon.setCoupon_verifier("as");
			dao.save(coupon);
			//验证是否增加信息成功
			Coupon a = dao.findByID(i);
			Coupon b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加成功!");
			}
		}
	}
	
	@Test
	public void testFindAll() {
		System.out.println("列出所有信息");
		CouponDao cp = new CouponDaoImpl();
		List<Coupon> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			Coupon a = coupon.get(i);
			System.out.println(a.getCoupon_id()+" "+a.getCoupon_name()+" "+a.getCoupon_how_many()+
					" "+a.getCoupon_type()+" "+a.getCoupon_lower_bound()+" "+a.getCoupon_value()+
					" "+a.getCoupon_cost_allocation()+" "+a.getCoupon_user_lever()+" "+a.getCoupon_user_range()+
					" "+a.getCoupon_begin_time()+" "+a.getCoupon_end_time()+" "+a.getCoupon_status()+
					" "+a.getCoupon_verifier()+" "+a.getCoupon_note()+" ");
		}
		System.out.println("列出所有信息成功!");
	}
	
	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=13;
		CouponDao dao=new CouponDaoImpl();
		Coupon coupon=dao.findByID(i);
		//判断该ID是否存在
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setCoupon_name("change");
			dao.update(coupon);
			//验证是否更新信息成功
			Coupon a = dao.findByID(i);
			if(!a.getCoupon_name().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新成功!");
		}
		
	}
	
	@Test
	public void testDelete() {
		System.out.println("删除一行指定ID信息");
		int i=19;
		CouponDao dao=new CouponDaoImpl();
		Coupon coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除成功
		Coupon a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除成功!");
		}
	}
}
