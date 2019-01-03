package db.dao;

import java.util.List;

import db.entity.Coupon;

public interface CouponDao extends BaseDao{

	public Coupon findByID(int coupon_id);
	
	public List<Coupon> findAll();
	
	public List<Coupon> findByUserType(String user_lever);

}
