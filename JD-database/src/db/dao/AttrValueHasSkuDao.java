package db.dao;

import java.util.List;

import db.entity.AttrValueHasSku;

public interface AttrValueHasSkuDao extends BaseDao{

	public AttrValueHasSku findByID(int attr_value_has_sku_id);
	
	public List<AttrValueHasSku> findAll();
	
	public List<AttrValueHasSku> findBySkuID(int sku_id);
}
