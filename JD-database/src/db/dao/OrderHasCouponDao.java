package db.dao;

import java.util.List;


import db.entity.OrderHasCoupon;

public interface OrderHasCouponDao extends BaseDao{

	public List<OrderHasCoupon> findAll();
	
	public OrderHasCoupon findByID(int order_has_coupon_id);
	
	public List<OrderHasCoupon> findByCouponID(int coupon_id);
}
