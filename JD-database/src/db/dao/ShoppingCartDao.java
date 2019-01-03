package db.dao;

import java.util.List;

import db.entity.ShoppingCart;

public interface ShoppingCartDao extends BaseDao{

	public ShoppingCart findByID(int shoppingcart_id);
	
	public List<ShoppingCart> findAll();
	
	public List<ShoppingCart> findByUserID(int user_id);
}
