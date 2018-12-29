package db.entity;

public class OrderHasCoupon {

	private int order_order_id;
	private int coupon_coupon_id;
	
	public int getOrder_order_id() {
		return order_order_id;
	}
	
	public void setOrder_order_id(int order_order_id) {
		this.order_order_id = order_order_id;
	}
	
	public int getCoupon_coupon_id() {
		return coupon_coupon_id;
	}
	
	public void setCoupon_coupon_id(int coupon_coupon_id) {
		this.coupon_coupon_id = coupon_coupon_id;
	}
	
	
}
