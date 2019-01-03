package db.dao;

import java.util.List;

import db.entity.CouponUseRange;

public interface CouponUseRangeDao extends BaseDao{

	public CouponUseRange findByID(int coupon_use_range);
	
	public List<CouponUseRange> findAll();
	
	public List<CouponUseRange> findByCouponID(int coupon_id);
	
	public List<CouponUseRange> findByRangeID(int range_id);
}
