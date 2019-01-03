package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.AddrDao;
import db.dao.AddrDaoImpl;
import db.entity.Addr;
import db.entity.Advertise;

public class AddrDaoImplTest {

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
		System.out.println("通过地址ID输出一行信息");
		AddrDao dao = new AddrDaoImpl();
		int i=13;
		Addr a = dao.findByID(i);
		//测试是否找到该地址ID
		if(a == null) {
			System.out.println("没有地址ID为 "+i+" 的地址信息");
		}
		else {
			System.out.println("查找地址ID为"+a.getAddr_id()+" 的一行地址信息成功!");}
	}

	@Test
	public void testFindAll() {
		System.out.println("列出所有地址信息");
		AddrDao ad = new AddrDaoImpl();
		List<Addr> addr = ad.findAll();
		for(int i = 0; i < addr.size(); i++) {
			Addr a = addr.get(i);
			System.out.println(a.getAddr_id()+" "+a.getUser_user_id()+" "+a.getAddr_name()+" "+
							   a.getAddr_area()+" "+a.getAddr_city()+" "+a.getAddr_country()+" "+
							   a.getAddr_detail()+" "+a.getAddr_province()+" "+a.getAddr_tel()+" ");
		}
		System.out.println("列出所有地址信息成功!");
	}

	@Test
	public void testFindByUserID() {
		/*System.out.println("通过查找用户ID输出所有地址信息");
		AddrDao ad = new AddrDaoImpl();
		int i=126;
		List<Addr> addr = ad.findByUserID(i);
		for(int j = 0; j < addr.size(); j++) {
			Addr a = addr.get(j);
			System.out.println(a.getAddr_id()+" "+a.getUser_user_id()+" "+a.getAddr_name()+" "+
							   a.getAddr_area()+" "+a.getAddr_city()+" "+a.getAddr_country()+" "+
							   a.getAddr_detail()+" "+a.getAddr_province()+" "+a.getAddr_tel()+" ");
		}
		System.out.println("查找用户ID为"+i+" 的所有地址信息成功!");*/
	}

	@Test
	public void testSave() {
		/*System.out.println("增加地址信息");
		int i=13;
		int j=19;
		AddrDao dao = new AddrDaoImpl();
		Addr a1=dao.findByID(i);
		Addr a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该地址ID!");
		}
		else {
			Addr addr = new Addr();
			addr.setAddr_id(i);
			addr.setAddr_area("abc");
			addr.setAddr_city("abc");
			addr.setAddr_country("abc");
			addr.setAddr_detail("abc");
			addr.setAddr_is_default(true);
			addr.setAddr_name("abc");
			addr.setAddr_province("abc");
			addr.setAddr_tel("123");
			addr.setUser_user_id(126);
			dao.save(addr);
			addr.setAddr_id(j);
			addr.setAddr_area("abc");
			addr.setAddr_city("abc");
			addr.setAddr_country("abc");
			addr.setAddr_detail("abc");
			addr.setAddr_is_default(true);
			addr.setAddr_name("abc");
			addr.setAddr_province("abc");
			addr.setAddr_tel("123");
			addr.setUser_user_id(126);
			dao.save(addr);
			//验证是否增加地址信息成功
			Addr a = dao.findByID(i);
			Addr b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加地址ID为 "+i+" 和 "+j+" 的地址信息成功!");
			}
		}*/
	}
	
	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=13;
		AddrDao dao=new AddrDaoImpl();
		Addr addr=dao.findByID(i);
		//判断该地址ID是否存在
		if(addr==null) {
			System.out.println("Find Error!");
		}
		else {
			addr.setAddr_city("change");
			dao.update(addr);
			//验证是否更新地址信息成功
			Addr a = dao.findByID(i);
			if(!a.getAddr_city().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新地址ID为"+i+" 的地址信息成功!");
		}
		
	}
	
	@Test
	public void testDelete() {
		System.out.println("删除一行指定地址ID信息");
		int i=19;
		AddrDao dao=new AddrDaoImpl();
		Addr addr= dao.findByID(i);
		if(addr!=null) {
			try {
				dao.delete(addr);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除地址信息成功
		Addr a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除地址ID为 "+i+" 的地址信息成功!");
		}
	}
}
