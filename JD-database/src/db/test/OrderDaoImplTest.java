package db.test;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.dao.OrderDao;
import db.dao.OrderDaoImpl;
import db.entity.Order;

public class OrderDaoImplTest {

	
	@Before
	public void setUp() throws Exception {
	}

	

	@Test
	public void testFindAll() {
		System.out.println("列出所有订单信息");
		OrderDao dao = new OrderDaoImpl();
		List<Order> or = dao.findAll();
		for(int i = 0; i < or.size(); i++) {
			Order a = or.get(i);
			System.out.println(a.getOrder_id()+" "+a.getAddr_addr_id()+" "+a.getOrder_delivery_no()+" "+
							   a.getOrder_delivery_price()+" "+a.getOrder_no()+" "+a.getOrder_note()+" "+
							   a.getOrder_platform_discount()+" "+a.getOrder_real_price()+" "+a.getOrder_sku_sum()+" "+
							   a.getOrder_status()+" "+a.getOrder_store_discount()+" "+a.getOrder_time_deal()+" "+
							   a.getOrder_time_order()+" "+a.getOrder_time_pay()+" "+a.getOrder_total_price()+" "+
							   a.getPay_channel_pay_channel_id()+" "+a.getUser_user_id());
		}
		System.out.println("列出所有订单信息成功!");
	}

	@Test
	public void testFindByID() {
		System.out.println("通过订单ID输出一行信息");
		OrderDao dao = new OrderDaoImpl();
		int i=13;
		Order a = dao.findByID(i);
		//测试是否找到该地址ID
		if(a == null) {
			System.out.println("没有订单ID为 "+i+" 的订单信息");
		}
		else {
			System.out.println("查找订单ID为"+a.getOrder_id()+" 的一行订单信息成功!");}
	}
	
	@Test
	public void testFindByUserID() {
		System.out.println("通过查找用户ID输出所有订单信息");
		OrderDao dao = new OrderDaoImpl();
		int i=126;
		List<Order> or = dao.findByUserID(i);
		for(int j = 0; j < or.size(); j++) {
			Order a = or.get(j);
			System.out.println(a.getOrder_id()+" "+a.getAddr_addr_id()+" "+a.getOrder_delivery_no()+" "+
					   a.getOrder_delivery_price()+" "+a.getOrder_no()+" "+a.getOrder_note()+" "+
					   a.getOrder_platform_discount()+" "+a.getOrder_real_price()+" "+a.getOrder_sku_sum()+" "+
					   a.getOrder_status()+" "+a.getOrder_store_discount()+" "+a.getOrder_time_deal()+" "+
					   a.getOrder_time_order()+" "+a.getOrder_time_pay()+" "+a.getOrder_total_price()+" "+
					   a.getPay_channel_pay_channel_id()+" "+a.getUser_user_id());
		}
		System.out.println("查找用户ID为"+i+" 的所有订单信息成功!");
	}

	@Test
	public void testSave() {
		System.out.println("增加订单信息");
		int i=18;
		int j=19;
		OrderDao dao = new OrderDaoImpl();
		Order a1=dao.findByID(i);
		Order a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该订单ID!");
		}
		else {
			Order or = new Order();
			or.setOrder_id(i);
			or.setAddr_addr_id(1);
			or.setOrder_delivery_no("123");
			or.setOrder_delivery_price(1);
			or.setOrder_no("123");
			or.setOrder_note("abc");
			or.setOrder_platform_discount(1);
			or.setOrder_real_price(1);
			or.setOrder_sku_sum(1);
			or.setOrder_status(1);
			or.setOrder_store_discount(1);
			or.setOrder_time_deal("2018-12-01 01:00:00");
			or.setOrder_time_delivery("2018-12-01 01:00:00");
			or.setOrder_time_order("2018-12-01 01:00:00");
			or.setOrder_time_pay("2018-12-01 01:00:00");
			or.setOrder_total_price(1);
			or.setPay_channel_pay_channel_id(1);
			or.setUser_user_id(1);
			dao.save(or);
			or.setOrder_id(j);
			or.setAddr_addr_id(1);
			or.setOrder_delivery_no("123");
			or.setOrder_delivery_price(1);
			or.setOrder_no("123");
			or.setOrder_note("abc");
			or.setOrder_platform_discount(1);
			or.setOrder_real_price(1);
			or.setOrder_sku_sum(1);
			or.setOrder_status(1);
			or.setOrder_store_discount(1);
			or.setOrder_time_deal("2018-12-01 01:00:00");
			or.setOrder_time_delivery("2018-12-01 01:00:00");
			or.setOrder_time_order("2018-12-01 01:00:00");
			or.setOrder_time_pay("2018-12-01 01:00:00");
			or.setOrder_total_price(1);
			or.setPay_channel_pay_channel_id(1);
			or.setUser_user_id(1);
			dao.save(or);
			//验证是否增加订单信息成功
			Order a = dao.findByID(i);
			Order b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加订单ID为 "+i+" 和 "+j+" 的订单信息成功!");
			}
		}
	}

	

	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=18;
		OrderDao dao=new OrderDaoImpl();
		Order or=dao.findByID(i);
		//判断该订单ID是否存在
		if(or==null) {
			System.out.println("Find Error!");
		}
		else {
			or.setOrder_note("change");
			dao.update(or);
			//验证是否更新订单信息成功
			Order a = dao.findByID(i);
			if(!a.getOrder_note().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新订单ID为"+i+" 的订单信息成功!");
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("删除一行指定订单ID信息");
		int i=19;
		OrderDao dao=new OrderDaoImpl();
		Order or= dao.findByID(i);
		if(or!=null) {
			try {
				dao.delete(or);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除订单信息成功
		Order a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除订单ID为 "+i+" 的订单信息成功!");
		}
	}
}
