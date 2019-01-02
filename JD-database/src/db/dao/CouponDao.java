package db.dao;

import java.util.List;

import db.entity.Coupon;

public interface CouponDao {

	public Coupon findByID();
	
	public List<Coupon> findAll();
	
	public List<Coupon> findByUserType(String user_type);

}
