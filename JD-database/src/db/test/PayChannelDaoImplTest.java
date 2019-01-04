package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.PayChannelDao;
import db.dao.PayChannelDaoImpl;
import db.entity.PayChannel;


public class PayChannelDaoImplTest {

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
		PayChannelDao dao = new PayChannelDaoImpl();
		int i=13;
		PayChannel a = dao.findByID(i);
		if(a == null) {
			System.out.println("没有ID为 "+i+" 的信息");
		}
		else {
			System.out.println("查找ID为"+a.getPay_channel_id()+" 的一行信息成功!");}
	}

	@Test
	public void testFindAll() {
		System.out.println("列出所有信息");
		PayChannelDao cp = new PayChannelDaoImpl();
		List<PayChannel> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			PayChannel a = coupon.get(i);
			System.out.println(a.getPay_channel_id()+" "+a.getPay_channel_type()+" "+a.getPay_channel_type_no()+" "+a.getUser_user_id()+" ");
		}
		System.out.println("列出所有信息成功!");
	}

	@Test
	public void testFindByUserID() {
		System.out.println("通过查找用户ID输出所有信息");
		PayChannelDao ad = new PayChannelDaoImpl();
		int i=1;
		List<PayChannel> addr = ad.findByUserID(i);
		for(int j = 0; j < addr.size(); j++) {
			PayChannel a = addr.get(j);
			System.out.println(a.getPay_channel_id()+" "+a.getPay_channel_type()+" "+a.getPay_channel_type_no()+" "+a.getUser_user_id()+" ");
		}
		System.out.println("查找用户ID为"+i+" 的所有信息成功!");
	}
	
	@Test
	public void testSave() {
		System.out.println("增加信息");
		PayChannelDao dao = new PayChannelDaoImpl();
		int i=13;
		int j=19;
		PayChannelDao br = new PayChannelDaoImpl();
		PayChannel a1 = dao.findByID(i);
		PayChannel a2 = dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该ID!");
		}
		else {
			PayChannel coupon = new PayChannel();
			coupon.setPay_channel_id(i);
			coupon.setPay_channel_type(0);
			coupon.setPay_channel_type_no("1234");
			coupon.setUser_user_id(1);
			dao.save(coupon);
			coupon.setPay_channel_id(j);
			coupon.setPay_channel_type(0);
			coupon.setPay_channel_type_no("1234");
			coupon.setUser_user_id(1);
			dao.save(coupon);
			//验证是否增加信息成功
			PayChannel a = dao.findByID(i);
			PayChannel b = dao.findByID(j);
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
		System.out.println("删除一行指定ID信息");
		int i=19;
		PayChannelDao dao=new PayChannelDaoImpl();
		PayChannel coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除成功
		PayChannel a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除成功!");
		}
	}
	
	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=13;
		PayChannelDao dao=new PayChannelDaoImpl();
		PayChannel coupon=dao.findByID(i);
		//判断该ID是否存在
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setPay_channel_type(2);
			dao.update(coupon);
			//验证是否更新信息成功
			PayChannel a = dao.findByID(i);
			if(a.getPay_channel_type()!=2) {
				System.out.println("Update Error!");
			}
			System.out.println("更新成功!");
		}
	}
}
