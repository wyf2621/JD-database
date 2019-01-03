package db.dao;

import java.util.List;

import db.entity.ShoppingCartHasSku;

public interface ShoppingCartHasSkuDao extends BaseDao{

	public ShoppingCartHasSku findByID(int shooping_cart_has_sku);
	
	public List<ShoppingCartHasSku> findAll();
	
	public List<ShoppingCartHasSku> findBySkuID(int sku_id);
}
