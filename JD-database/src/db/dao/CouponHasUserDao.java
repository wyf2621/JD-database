package db.dao;

import java.util.List;

import db.entity.CouponHasUser;

public interface CouponHasUserDao {

	public CouponHasUser findByID(int coupon_has_user_id);
	
	public List<CouponHasUser> findAll();
	
	public List<CouponHasUser> findByUserID(int user_id);
}
