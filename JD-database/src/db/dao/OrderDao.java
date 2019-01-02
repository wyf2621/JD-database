package db.dao;

import java.util.List;

import db.entity.Order;

public interface OrderDao {

	public Order findByID(int order_id);
	
	public List<Order> findAll();
	
	public List<Order> findByUserID(int user_id);
}
