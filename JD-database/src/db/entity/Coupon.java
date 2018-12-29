package db.entity;

public class Coupon {

	private int coupon_id;
	private String coupon_name;
	private int coupon_how_many;
	private float coupon_lower_bound;
	private float coupon_value;
	private int coupon_cost_allocation;
	private String coupon_user_lever;
	private int coupon_user_range;
	private String coupon_begin_time;
	private String coupon_end_time;
	private int coupon_status;
	private String coupon_verifier;
	private boolean coupon_is_deleted;
	private String coupon_note;

	public int getCoupon_id() {
		return coupon_id;
	}
	
	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}
	
	public String getCoupon_name() {
		return coupon_name;
	}
	
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	
	public int getCoupon_how_many() {
		return coupon_how_many;
	}
	
	public void setCoupon_how_many(int coupon_how_many) {
		this.coupon_how_many = coupon_how_many;
	}
	
	public float getCoupon_lower_bound() {
		return coupon_lower_bound;
	}
	
	public void setCoupon_lower_bound(float coupon_lower_bound) {
		this.coupon_lower_bound = coupon_lower_bound;
	}
	
	public float getCoupon_value() {
		return coupon_value;
	}
	
	public void setCoupon_value(float coupon_value) {
		this.coupon_value = coupon_value;
	}
	
	public int getCoupon_cost_allocation() {
		return coupon_cost_allocation;
	}
	
	public void setCoupon_cost_allocation(int coupon_cost_allocation) {
		this.coupon_cost_allocation = coupon_cost_allocation;
	}
	
	public String getCoupon_user_lever() {
		return coupon_user_lever;
	}
	
	public void setCoupon_user_lever(String coupon_user_lever) {
		this.coupon_user_lever = coupon_user_lever;
	}
	
	public int getCoupon_user_range() {
		return coupon_user_range;
	}
	
	public void setCoupon_user_range(int coupon_user_range) {
		this.coupon_user_range = coupon_user_range;
	}
	
	public String getCoupon_begin_time() {
		return coupon_begin_time;
	}
	
	public void setCoupon_begin_time(String coupon_begin_time) {
		this.coupon_begin_time = coupon_begin_time;
	}
	
	public String getCoupon_end_time() {
		return coupon_end_time;
	}
	
	public void setCoupon_end_time(String coupon_end_time) {
		this.coupon_end_time = coupon_end_time;
	}
	
	public int getCoupon_status() {
		return coupon_status;
	}
	
	public void setCoupon_status(int coupon_status) {
		this.coupon_status = coupon_status;
	}
	
	
	public String getCoupon_verifier() {
		return coupon_verifier;
	}
	
	public void setCoupon_verifier(String coupon_verifier) {
		this.coupon_verifier = coupon_verifier;
	}
	
	public boolean isCoupon_is_deleted() {
		return coupon_is_deleted;
	}
	
	public void setCoupon_is_deleted(boolean coupon_is_deleted) {
		this.coupon_is_deleted = coupon_is_deleted;
	}
	
	public String getCoupon_note() {
		return coupon_note;
	}
	
	public void setCoupon_note(String coupon_note) {
		this.coupon_note = coupon_note;
	}
}
