package db.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


import db.dao.ReturnDao;
import db.dao.ReturnDaoImpl;
import db.entity.Return;

public class ReturnDaoImplTest {


	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testFindByID() {
		System.out.println("通过退货ID输出一行信息");
		ReturnDao dao = new ReturnDaoImpl();
		int i=1;
		Return a = dao.findByID(i);
		//测试是否找到该退货ID
		if(a == null) {
			System.out.println("没有退货ID为 "+i+" 的广告信息");
		}
		else {
			System.out.println("查找退货ID为"+i+" 的一行信息成功!");}
	}

	@Test
	public void testFindAll() {
		System.out.println("列出所有退货信息");
		ReturnDao dao = new ReturnDaoImpl();
		List<Return> ad = dao.findAll();
		for(int i = 0; i < ad.size(); i++) {
			Return a = ad.get(i);
			System.out.println(a.getReturn_id()+" "+a.getOrder_order_id()+" "+a.getReturn_amount()+" "+
							   a.getReturn_apply_time()+" "+a.getReturn_delivery_no()+" "+a.getReturn_end_time()+" "+
							   a.getReturn_no()+" "+a.getReturn_note()+" "+a.getReturn_reason()+" "+a.getReturn_start_time()+" "+
							   a.getReturn_status()+" "+a.getUser_user_id());
		}
		System.out.println("列出所有退货信息成功!");
	}

	@Test
	public void testFindByUserID() {
		System.out.println("通过查找用户ID输出所有退货信息");
		ReturnDao dao = new ReturnDaoImpl();
		int i=1;
		List<Return> ad = dao.findByUserID(i);
		for(int j = 0; j < ad.size(); j++) {
			Return a = ad.get(j);
			System.out.println(a.getReturn_id()+" "+a.getOrder_order_id()+" "+a.getReturn_amount()+" "+
					   a.getReturn_apply_time()+" "+a.getReturn_delivery_no()+" "+a.getReturn_end_time()+" "+
					   a.getReturn_no()+" "+a.getReturn_note()+" "+a.getReturn_reason()+" "+a.getReturn_start_time()+" "+
					   a.getReturn_status()+" "+a.getUser_user_id());
		}
		System.out.println("查找用户ID为"+i+" 的所有退货信息成功!");
	}

	@Test
	public void testFindByOrderID() {
		System.out.println("通过查找订单ID输出所有退货信息");
		ReturnDao dao = new ReturnDaoImpl();
		int i=0;
		List<Return> ad = dao.findByOrderID(i);
		for(int j = 0; j < ad.size(); j++) {
			Return a = ad.get(j);
			System.out.println(a.getReturn_id()+" "+a.getOrder_order_id()+" "+a.getReturn_amount()+" "+
					   a.getReturn_apply_time()+" "+a.getReturn_delivery_no()+" "+a.getReturn_end_time()+" "+
					   a.getReturn_no()+" "+a.getReturn_note()+" "+a.getReturn_reason()+" "+a.getReturn_start_time()+" "+
					   a.getReturn_status()+" "+a.getUser_user_id());
		}
		System.out.println("查找订单ID为"+i+" 的所有退货信息成功!");
	}
	

	@Test
	public void testSave() {
		System.out.println("增加退货信息");
		int i=18;
		int j=19;
		ReturnDao dao = new ReturnDaoImpl();
		Return a1=dao.findByID(i);
		Return a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该退货ID!");
		}
		else {
			Return ad = new Return();
			ad.setReturn_id(i);
			ad.setOrder_order_id(1);
			ad.setReturn_amount(1);
			ad.setReturn_apply_time("2008-08-08 00:00:00");
			ad.setReturn_delivery_no("123");
			ad.setReturn_no(123);
			ad.setReturn_end_time("2008-08-08 00:00:00");
			ad.setReturn_note("abc");
			ad.setReturn_start_time("2008-08-08 00:00:00");
			ad.setReturn_status(1);
			ad.setUser_user_id(1);
			dao.save(ad);
			ad.setReturn_id(j);
			ad.setOrder_order_id(1);
			ad.setReturn_amount(1);
			ad.setReturn_apply_time("2008-08-08 00:00:00");
			ad.setReturn_delivery_no("123");
			ad.setReturn_no(123);
			ad.setReturn_end_time("2008-08-08 00:00:00");
			ad.setReturn_note("abc");
			ad.setReturn_start_time("2008-08-08 00:00:00");
			ad.setReturn_status(1);
			ad.setUser_user_id(1);
			dao.save(ad);
			//验证是否增加退货信息成功
			Return a = dao.findByID(i);
			Return b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加退货ID为 "+i+" 和 "+j+" 的退货信息成功!");
			}
		}
	}

	@Test
	public void testDelete() {
		System.out.println("删除一行指定退货ID信息");
		int i=19;
		ReturnDao dao = new ReturnDaoImpl();
		Return ad= dao.findByID(i);
		if(ad!=null) {
			try {
				dao.delete(ad);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除退货信息成功
		Return a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除退货ID为 "+i+" 的退货信息成功!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=18;
		ReturnDao dao = new ReturnDaoImpl();
		Return ad=dao.findByID(i);
		//判断该退货ID是否存在
		if(ad==null) {
			System.out.println("Find Error!");
		}
		else {
			ad.setReturn_note("change");
			dao.update(ad);
			//验证是否更新退货信息成功
			Return a = dao.findByID(i);
			if(!a.getReturn_note().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新退货ID为"+i+" 的退货信息成功!");
		}
	}

}
