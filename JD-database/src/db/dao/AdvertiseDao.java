package db.dao;

import java.util.List;

import db.entity.Advertise;

public interface AdvertiseDao {

	public Advertise findByID(int ad_id);
	
	public  List<Advertise> findAll();
	
	public  List<Advertise> findByAdID(int ad_id);
}
