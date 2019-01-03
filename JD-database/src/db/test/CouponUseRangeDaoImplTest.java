package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.CouponUseRangeDao;
import db.dao.CouponUseRangeDaoImpl;
import db.entity.CouponUseRange;



public class CouponUseRangeDaoImplTest {

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
		CouponUseRangeDao dao = new CouponUseRangeDaoImpl();
		int i=13;
		CouponUseRange a = dao.findByID(i);
		if(a == null) {
			System.out.println("没有ID为 "+i+" 的信息");
		}
		else {
			System.out.println("查找ID为"+a.getCoupon_coupon_id()+" 的一行信息成功!");}
	}

	@Test
	public void testSave() {
		System.out.println("增加信息");
		CouponUseRangeDao dao = new CouponUseRangeDaoImpl();
		int i=13;
		int j=19;
		CouponUseRangeDao br = new CouponUseRangeDaoImpl();
		CouponUseRange a1 = dao.findByID(i);
		CouponUseRange a2 = dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该ID!");
		}
		else {
			CouponUseRange coupon = new CouponUseRange();
			coupon.setCoupon_coupon_id(1);
			coupon.setCoupon_use_range_id(i);
			coupon.setUse_range_id(2);
			dao.save(coupon);
			coupon.setCoupon_coupon_id(1);
			coupon.setCoupon_use_range_id(i);
			coupon.setUse_range_id(2);
			dao.save(coupon);
			//验证是否增加信息成功
			CouponUseRange a = dao.findByID(i);
			CouponUseRange b = dao.findByID(j);
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
		CouponUseRangeDao cp = new CouponUseRangeDaoImpl();
		List<CouponUseRange> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			CouponUseRange a = coupon.get(i);
			System.out.println(a.getCoupon_coupon_id()+" "+a.getCoupon_use_range_id()+" "+a.getUse_range_id()+" ");
		}
		System.out.println("列出所有信息成功!");
	}
	
	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=13;
		CouponUseRangeDao dao=new CouponUseRangeDaoImpl();
		CouponUseRange coupon=dao.findByID(i);
		//判断该ID是否存在
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setUse_range_id(2);
			dao.update(coupon);
			//验证是否更新信息成功
			CouponUseRange a = dao.findByID(i);
			if(a.getUse_range_id()!=2) {
				System.out.println("Update Error!");
			}
			System.out.println("更新成功!");
		}
		
	}
	
	@Test
	public void testDelete() {
		System.out.println("删除一行指定ID信息");
		int i=19;
		CouponUseRangeDao dao=new CouponUseRangeDaoImpl();
		CouponUseRange coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除成功
		CouponUseRange a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除成功!");
		}
	}
}
