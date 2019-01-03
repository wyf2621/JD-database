package db.dao;

import java.util.List;

import db.entity.SkuHasReturn;

public interface SkuHasReturnDao extends BaseDao{

	public SkuHasReturn findByID(int sku_has_return_id);
	
	public List<SkuHasReturn> findAll();
	
	public List<SkuHasReturn> findByReturnID(int return_id);
}
