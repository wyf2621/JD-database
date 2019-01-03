package db.dao;

import java.util.List;

import db.entity.Brand;

public interface BrandDao extends BaseDao{

	public Brand findByID(int brand_id);
	
	public List<Brand> findAll();
}
