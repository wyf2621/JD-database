package db.test;


import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.AddrDao;
import db.dao.AddrDaoImpl;
import db.dao.AdvertiseDao;
import db.dao.AdvertiseDaoImpl;
import db.entity.Addr;
import db.entity.Advertise;

import java.util.List;



import db.dao.AdvertiseInfoDao;
import db.dao.AdvertiseInfoDaoImpl;

import db.entity.AdvertiseInfo;

public class AdvertiseInfoDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testFindByID() {
		System.out.println("通过广告详细信息ID输出一行信息");
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		int i=18;
		AdvertiseInfo a = dao.findByID(i);
		//测试是否找到该广告详细信息ID
		if(a == null) {
			System.out.println("没有广告详细信息ID为 "+i+" 的详细信息");
		}
		else {
			System.out.println("查找广告详细信息ID为"+a.getAd_info_id()+" 的一行详细信息成功!");}
	}

	@Test
	public void testFindAll() {
		System.out.println("列出所有广告详细信息信息");
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		List<AdvertiseInfo> adinfo = dao.findAll();
		for(int i = 0; i < adinfo.size(); i++) {
			AdvertiseInfo a = adinfo.get(i);
			System.out.println(a.getAd_info_id()+" "+a.getAd_begin_time()+" "+a.getAd_click_time()+" "+
							   a.getAd_create_time()+" "+a.getAd_during_time()+" "+a.getAd_end_time()+" "+
							   a.getAd_file_path()+" "+a.getAd_file_size()+" "+a.getAd_file_type()+" "+
							   a.getAd_info_status()+" "+a.getAd_info_title()+" "+a.getAd_link_url()+" "+
							   a.getAd_note()+" "+a.getAd_scan_time()+" "+a.getAdvertise_ad_id()+" "+a.getStore_store_id());
		}
		System.out.println("列出所有广告详细信息成功!");
	}

	@Test
	public void testFindByStoreID() {
		System.out.println("通过查找店铺ID输出所有广告详细信息");
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		int i=126;
		List<AdvertiseInfo> adinfo = dao.findByStoreID(i);
		for(int j = 0; j < adinfo.size(); j++) {
			AdvertiseInfo a = adinfo.get(j);
			System.out.println(a.getAd_info_id()+" "+a.getAd_begin_time()+" "+a.getAd_click_time()+" "+
					   a.getAd_create_time()+" "+a.getAd_during_time()+" "+a.getAd_end_time()+" "+
					   a.getAd_file_path()+" "+a.getAd_file_size()+" "+a.getAd_file_type()+" "+
					   a.getAd_info_status()+" "+a.getAd_info_title()+" "+a.getAd_link_url()+" "+
					   a.getAd_note()+" "+a.getAd_scan_time()+" "+a.getAdvertise_ad_id()+" "+a.getStore_store_id());
		}
		System.out.println("查找店铺ID为"+i+" 的所有广告详细信息成功!");
	}

	@Test
	public void testFindByAdID() {
		System.out.println("通过查找广告ID输出所有广告详细信息");
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		int i=126;
		List<AdvertiseInfo> adinfo = dao.findByStoreID(i);
		for(int j = 0; j < adinfo.size(); j++) {
			AdvertiseInfo a = adinfo.get(j);
			System.out.println(a.getAd_info_id()+" "+a.getAd_begin_time()+" "+a.getAd_click_time()+" "+
					   a.getAd_create_time()+" "+a.getAd_during_time()+" "+a.getAd_end_time()+" "+
					   a.getAd_file_path()+" "+a.getAd_file_size()+" "+a.getAd_file_type()+" "+
					   a.getAd_info_status()+" "+a.getAd_info_title()+" "+a.getAd_link_url()+" "+
					   a.getAd_note()+" "+a.getAd_scan_time()+" "+a.getAdvertise_ad_id()+" "+a.getStore_store_id());
		}
		System.out.println("查找广告ID为"+i+" 的广告详细信息成功!");
	}

	@Test
	public void testSave() {
		System.out.println("增加广告详细信息");
		int i=18;
		int j=19;
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		AdvertiseInfo a1=dao.findByID(i);
		AdvertiseInfo a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该广告详细信息ID!");
		}
		else {
			AdvertiseInfo adinfo = new AdvertiseInfo();
			adinfo.setAd_info_id(i);
			adinfo.setAd_begin_time("2008-08-08 00:00:00");
			adinfo.setAd_click_time(1);
			adinfo.setAd_create_time("2008-08-08 00:00:00");
			adinfo.setAd_during_time("2008-08-08 00:00:00");
			adinfo.setAd_end_time("2008-08-08 00:00:00");
			adinfo.setAd_file_path("abc");
			adinfo.setAd_file_size(1);
			adinfo.setAd_file_type("abc");
			adinfo.setAd_info_status(1);
			adinfo.setAd_info_title("abc");
			adinfo.setAd_is_period(true);
			adinfo.setAd_link_url("abc");
			adinfo.setAd_note("abc");
			adinfo.setAd_scan_time(1);
			adinfo.setAdvertise_ad_id(1);
			adinfo.setStore_store_id(1);
			dao.save(adinfo);
			adinfo.setAd_info_id(j);
			adinfo.setAd_begin_time("2008-08-08 00:00:00");
			adinfo.setAd_click_time(1);
			adinfo.setAd_create_time("2008-08-08 00:00:00");
			adinfo.setAd_during_time("2008-08-08 00:00:00");
			adinfo.setAd_end_time("2008-08-08 00:00:00");
			adinfo.setAd_file_path("abc");
			adinfo.setAd_file_size(1);
			adinfo.setAd_file_type("abc");
			adinfo.setAd_info_status(1);
			adinfo.setAd_info_title("abc");
			adinfo.setAd_is_period(true);
			adinfo.setAd_link_url("abc");
			adinfo.setAd_note("abc");
			adinfo.setAd_scan_time(1);
			adinfo.setAdvertise_ad_id(1);
			adinfo.setStore_store_id(1);
			dao.save(adinfo);
			//验证是否增加地址信息成功
			AdvertiseInfo a = dao.findByID(i);
			AdvertiseInfo b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加广告详细信息ID为 "+i+" 和 "+j+" 的详细信息成功!");
			}
		}
	}

	
	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=18;
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		AdvertiseInfo adinfo=dao.findByID(i);
		//判断该广告详细信息ID是否存在
		if(adinfo==null) {
			System.out.println("Find Error!");
		}
		else {
			adinfo.setAd_info_title("change");
			dao.update(adinfo);
			//验证是否更新广告详细信息信息成功
			AdvertiseInfo a = dao.findByID(i);
			if(!a.getAd_info_title().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新广告详细信息ID为"+i+" 的详细信息成功!");
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("删除一行指定广告详细ID信息");
		int i=19;
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		AdvertiseInfo adinfo= dao.findByID(i);
		if(adinfo!=null) {
			try {
				dao.delete(adinfo);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除广告详细信息信息成功
		AdvertiseInfo a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除广告详细信息ID为 "+i+" 的详细信息成功!");
		}
	}
	
}
