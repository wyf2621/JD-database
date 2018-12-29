package db.entity;

public class CouponUseRange {

	private int coupon_use_range_id;
	private int coupon_coupon_id;
	private int use_range_id;
	
	public int getCoupon_use_range_id() {
		return coupon_use_range_id;
	}
	
	public void setCoupon_use_range_id(int coupon_use_range_id) {
		this.coupon_use_range_id = coupon_use_range_id;
	}
	
	public int getCoupon_coupon_id() {
		return coupon_coupon_id;
	}
	
	public void setCoupon_coupon_id(int coupon_coupon_id) {
		this.coupon_coupon_id = coupon_coupon_id;
	}
	
	public int getUse_range_id() {
		return use_range_id;
	}
	
	public void setUse_range_id(int use_range_id) {
		this.use_range_id = use_range_id;
	}
	
	
}
