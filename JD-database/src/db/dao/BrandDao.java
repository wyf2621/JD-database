package db.dao;

import java.util.List;

import db.entity.Brand;

public interface BrandDao {

	public Brand findByID(int brand_id);
	
	public List<Brand> findAll();
}
