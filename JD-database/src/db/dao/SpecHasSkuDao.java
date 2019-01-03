package db.dao;

import java.util.List;

import db.entity.SpecHasSku;

public interface SpecHasSkuDao extends BaseDao{

	public SpecHasSku findByID(int spec_spec_id);
	
	public List<SpecHasSku> findBySkuID(int sku_sku_id);
	
	public List<SpecHasSku> findAll();
		
}
