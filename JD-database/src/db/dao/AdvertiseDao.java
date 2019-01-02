package db.dao;

import java.util.List;

import db.entity.Advertise;

public interface AdvertiseDao extends BaseDao{

	public Advertise findByID(int ad_id);
	
	public  List<Advertise> findAll();
	
	public  List<Advertise> findByAdType(String ad_type);
}
