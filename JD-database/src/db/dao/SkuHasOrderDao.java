package db.dao;

import java.util.List;

import db.entity.SkuHasOrder;

public interface SkuHasOrderDao extends BaseDao{

	public SkuHasOrder findByID(int sku_has_order_id);
	
	public List<SkuHasOrder> findAll();
	
	public List<SkuHasOrder> findByOrderID(int order_id);
	
}

