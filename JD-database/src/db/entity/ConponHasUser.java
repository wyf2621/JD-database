package db.entity;

public class ConponHasUser {

	private int coupon_coupon_id;
	private int user_user_id;
	private String received_time;
	private boolean coupon_has_user_is_deleted;
	private int coupon_has_user_status;
	
	public int getCoupon_coupon_id() {
		return coupon_coupon_id;
	}
	
	
	public void setCoupon_coupon_id(int coupon_coupon_id) {
		this.coupon_coupon_id = coupon_coupon_id;
	}
	
	public int getUser_user_id() {
		return user_user_id;
	}
	
	public void setUser_user_id(int user_user_id) {
		this.user_user_id = user_user_id;
	}
	
	public String getReceived_time() {
		return received_time;
	}
	
	public void setReceived_time(String received_time) {
		this.received_time = received_time;
	}
	
	public boolean isCoupon_has_user_is_deleted() {
		return coupon_has_user_is_deleted;
	}
	
	public void setCoupon_has_user_is_deleted(boolean coupon_has_user_is_deleted) {
		this.coupon_has_user_is_deleted = coupon_has_user_is_deleted;
	}
	
	public int getCoupon_has_user_status() {
		return coupon_has_user_status;
	}
	
	public void setCoupon_has_user_status(int coupon_has_user_status) {
		this.coupon_has_user_status = coupon_has_user_status;
	}
}

