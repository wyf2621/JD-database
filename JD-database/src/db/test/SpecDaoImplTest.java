package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.SpecDao;
import db.dao.SpecDaoImpl;
import db.entity.Spec;


public class SpecDaoImplTest {

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
	public void testFindByID() {
		System.out.println("通过ID输出一行信息");
		SpecDao dao = new SpecDaoImpl();
		int i=13;
		Spec a = dao.findByID(i);
		if(a == null) {
			System.out.println("没有ID为 "+i+" 的信息");
		}
		else {
			System.out.println("查找ID为"+a.getSpec_id()+" 的一行信息成功!");}
	
	}
	
	@Test
	public void testFindByGroupID() {
		System.out.println("通过查找Group ID输出所有信息");
		SpecDao ad = new SpecDaoImpl();
		int i=126;
		List<Spec> addr = ad.findByGroupID(i);
		for(int j = 0; j < addr.size(); j++) {
			Spec a = addr.get(j);
			System.out.println(a.getSpec_id()+" "+a.getSpec_name()+" "+a.getSpec_group_spec_group_id());
		}
		System.out.println("查找Group ID为"+i+" 的所有信息成功!");
	}
	
	@Test
	public void testFindAll() {
		System.out.println("列出所有信息");
		SpecDao cp = new SpecDaoImpl();
		List<Spec> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			Spec a = coupon.get(i);
			System.out.println(a.getSpec_id()+" "+a.getSpec_name()+" "+a.getSpec_group_spec_group_id());
		}
		System.out.println("列出所有信息成功!");
	}	

	@Test
	public void testSave() {
		System.out.println("增加信息");
		SpecDao dao = new SpecDaoImpl();
		int i=13;
		int j=19;
		SpecDao br = new SpecDaoImpl();
		Spec a1 = dao.findByID(i);
		Spec a2 = dao.findByID(i);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该ID!");
		}
		else {
			Spec x = new Spec();
			x.setSpec_id(i);
			x.setSpec_name("name");
			x.setSpec_group_spec_group_id(1);
			dao.save(x);
			x.setSpec_id(j);
			x.setSpec_name("name");
			x.setSpec_group_spec_group_id(1);
			dao.save(x);
			//验证是否增加信息成功
			Spec a = dao.findByID(i);
			Spec b = dao.findByID(j);
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
		SpecDao dao = new SpecDaoImpl();
		Spec coupon=dao.findByID(i);
		//判断该ID是否存在
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setSpec_group_spec_group_id(2);
			dao.update(coupon);
			//验证是否更新信息成功
			Spec a = dao.findByID(i);
			if(a.getSpec_group_spec_group_id()!=2) {
				System.out.println("Update Error!");
			}
			System.out.println("更新成功!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("删除一行指定ID信息");
		int i=19;
		SpecDao dao = new SpecDaoImpl();
		Spec coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除成功
		Spec a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除成功!");
		}
	}
	}
