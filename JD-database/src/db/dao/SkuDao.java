package db.dao;

import java.util.List;

import db.entity.Sku;

public interface SkuDao {

	public Sku findByID(int sku_id);
	
	public List<Sku> findAll();
	
	public List<Sku> findBySpuID(int spu_id);
}
