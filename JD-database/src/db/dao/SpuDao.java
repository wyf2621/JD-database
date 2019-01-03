package db.dao;

import java.util.List;

import db.entity.Spu;

public interface SpuDao extends BaseDao{

	public List<Spu> findAll();
	
	public List<Spu> findByStoreID(int store_store_id);
	
	public List<Spu> findByBrandID(int brand_brand_id);
	
	public Spu findByID(int spu_id);
}
