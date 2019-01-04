package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.BrandDao;
import db.dao.BrandDaoImpl;
import db.entity.Brand;



public class BrandDaoImplTest {

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
		System.out.println("通过品牌ID输出一行信息");
		BrandDao dao = new BrandDaoImpl();
		int i=13;
		Brand a = dao.findByID(i);
		if(a == null) {
			System.out.println("没有品牌ID为 "+i+" 的信息");
		}
		else {
			System.out.println("查找品牌ID为"+a.getBrand_id()+" 的一行信息成功!");}
	}

	@Test
	public void testSave() {
		System.out.println("增加品牌信息");
		BrandDao dao = new BrandDaoImpl();
		int i=13;
		int j=19;
		BrandDao br = new BrandDaoImpl();
		Brand a1 = dao.findByID(i);
		Brand a2 = dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该品牌ID!");
		}
		else {
			Brand brand = new Brand();
			brand.setBrand_id(i);
			brand.setBrand_name("brand1");
			dao.save(brand);
			brand.setBrand_id(j);
			brand.setBrand_name("brand2");
			dao.save(brand);
			//验证是否增加信息成功
			Brand a = dao.findByID(i);
			Brand b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加品牌ID为 "+i+" 和 "+j+" 的信息成功!");
			}
		}
	}
	
	@Test
	public void testFindAll() {
		System.out.println("列出所有品牌信息");
		BrandDao br = new BrandDaoImpl();
		List<Brand> brand = br.findAll();
		for(int i = 0; i < brand.size(); i++) {
			Brand a = brand.get(i);
			System.out.println(a.getBrand_id()+" "+a.getBrand_name()+" ");
		}
		System.out.println("列出所有品牌信息成功!");
	}
	
	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=13;
		BrandDao dao=new BrandDaoImpl();
		Brand brand=dao.findByID(i);
		//判断该ID是否存在
		if(brand==null) {
			System.out.println("Find Error!");
		}
		else {
			brand.setBrand_name("change");
			dao.update(brand);
			//验证是否更新信息成功
			Brand a = dao.findByID(i);
			if(!a.getBrand_name().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新品牌ID为"+i+" 的信息成功!");
		}
		
	}
	
	@Test
	public void testDelete() {
		System.out.println("删除一行指定品牌ID信息");
		int i=19;
		BrandDao dao=new BrandDaoImpl();
		Brand brand= dao.findByID(i);
		if(brand!=null) {
			try {
				dao.delete(brand);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除成功
		Brand a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除品牌ID为 "+i+" 的信息成功!");
		}
	}
}
