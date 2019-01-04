package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.SkuDao;
import db.dao.SkuDaoImpl;
import db.entity.Sku;


public class SkuDaoImplTest {

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
		System.out.println("列出所有信息");
		SkuDao cp = new SkuDaoImpl();
		List<Sku> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			Sku a = coupon.get(i);
			System.out.println(a.getSku_id()+" "+a.getSku_name()+" "+a.getSku_price()+" "+a.getSku_store()+" "+a.getSpu_spu_id()+" ");
		}
		System.out.println("列出所有信息成功!");
	}

	
	@Test
	public void testfindBySpuID() {
		System.out.println("通过查找Spu ID输出所有信息");
		SkuDao ad = new SkuDaoImpl();
		int i=126;
		List<Sku> addr = ad.findBySpuID(i);
		for(int j = 0; j < addr.size(); j++) {
			Sku a = addr.get(j);
			System.out.println(a.getSku_id()+" "+a.getSku_name()+" "+a.getSku_price()+" "+a.getSku_store()+" "+a.getSpu_spu_id()+" ");
		}
		System.out.println("查找Spu ID为"+i+" 的所有信息成功!");
	}

	@Test
	public void testFindByID() {
		System.out.println("通过ID输出一行信息");
		SkuDao dao = new SkuDaoImpl();
		int i=13;
		Sku a = dao.findByID(i);
		if(a == null) {
			System.out.println("没有ID为 "+i+" 的信息");
		}
		else {
			System.out.println("查找ID为"+a.getSku_id()+" 的一行信息成功!");}
	
	}

	@Test
	public void testSave() {
		System.out.println("增加信息");
		SkuDao dao = new SkuDaoImpl();
		int i=13;
		int j=19;
		SkuDao br = new SkuDaoImpl();
		Sku a1 = dao.findByID(i);
		Sku a2 = dao.findByID(i);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该ID!");
		}
		else {
			Sku x = new Sku();
			x.setSku_id(i);
			x.setSku_name("111");
			x.setSku_price(1);
			x.setSku_store(21);
			x.setSpu_spu_id(21);
			dao.save(x);
			x.setSku_id(i);
			x.setSku_name("111");
			x.setSku_price(1);
			x.setSku_store(21);
			x.setSpu_spu_id(21);
			dao.save(x);
			//验证是否增加信息成功
			Sku a = dao.findByID(i);
			Sku b = dao.findByID(j);
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
		SkuDao dao = new SkuDaoImpl();
		Sku coupon=dao.findByID(i);
		//判断该ID是否存在
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setSku_name("change");;
			dao.update(coupon);
			//验证是否更新信息成功
			Sku a = dao.findByID(i);
			if(!a.getSku_name().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新成功!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("删除一行指定ID信息");
		int i=19;
		SkuDao dao = new SkuDaoImpl();
		Sku coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除成功
		Sku a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除成功!");
		}
	}
	}
