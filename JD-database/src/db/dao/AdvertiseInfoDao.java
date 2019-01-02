package db.dao;

import java.util.List;

import db.entity.AdvertiseInfo;

public interface AdvertiseInfoDao {

	public AdvertiseInfo findByID(int ad_info_id);
	
	public List<AdvertiseInfo> findAll();
	
	public List<AdvertiseInfo> findByStoreID(int store_id);
	
	public List<AdvertiseInfo>  findByAdID(int ad_id);
}
