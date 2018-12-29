package db.entity;

public class Order {

	private int order_id;
	private String order_no;
	private int order_sku_sum;
	private float order_total_price;
	private float order_real_price;
	private float order_delivery_price;
	private float order_store_discount;
	private float order_platform_discount;
	private String order_time_order;
	private String order_time_pay;
	private String order_time_delivery;
	private String order_time_deal;
	private String order_delivery_no;
	private String order_note;
	private int order_status;
	private int pay_channel_pay_channel_id;
	private int user_user_id;
	private int addr_addr_id;
	
	public int getOrder_id() {
		return order_id;
	}
	
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	public String getOrder_no() {
		return order_no;
	}
	
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	
	public int getOrder_sku_sum() {
		return order_sku_sum;
	}
	
	public void setOrder_sku_sum(int order_sku_sum) {
		this.order_sku_sum = order_sku_sum;
	}
	
	public float getOrder_total_price() {
		return order_total_price;
	}
	
	public void setOrder_total_price(float order_total_price) {
		this.order_total_price = order_total_price;
	}
	
	public float getOrder_real_price() {
		return order_real_price;
	}
	
	public void setOrder_real_price(float order_real_price) {
		this.order_real_price = order_real_price;
	}
	
	public float getOrder_delivery_price() {
		return order_delivery_price;
	}
	
	public void setOrder_delivery_price(float order_delivery_price) {
		this.order_delivery_price = order_delivery_price;
	}
	
	public float getOrder_store_discount() {
		return order_store_discount;
	}
	
	public void setOrder_store_discount(float order_store_discount) {
		this.order_store_discount = order_store_discount;
	}
	
	public float getOrder_platform_discount() {
		return order_platform_discount;
	}
	
	public void setOrder_platform_discount(float order_platform_discount) {
		this.order_platform_discount = order_platform_discount;
	}
	
	public String getOrder_time_order() {
		return order_time_order;
	}
	
	public void setOrder_time_order(String order_time_order) {
		this.order_time_order = order_time_order;
	}
	
	public String getOrder_time_pay() {
		return order_time_pay;
	}
	
	public void setOrder_time_pay(String order_time_pay) {
		this.order_time_pay = order_time_pay;
	}
	
	public String getOrder_time_delivery() {
		return order_time_delivery;
	}
	
	public void setOrder_time_delivery(String order_time_delivery) {
		this.order_time_delivery = order_time_delivery;
	}
	
	public String getOrder_time_deal() {
		return order_time_deal;
	}
	
	public void setOrder_time_deal(String order_time_deal) {
		this.order_time_deal = order_time_deal;
	}
	
	public String getOrder_delivery_no() {
		return order_delivery_no;
	}
	
	public void setOrder_delivery_no(String order_delivery_no) {
		this.order_delivery_no = order_delivery_no;
	}
	
	public String getOrder_note() {
		return order_note;
	}
	
	public void setOrder_note(String order_note) {
		this.order_note = order_note;
	}
	
	public int getOrder_status() {
		return order_status;
	}
	
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	
	public int getPay_channel_pay_channel_id() {
		return pay_channel_pay_channel_id;
	}
	
	public void setPay_channel_pay_channel_id(int pay_channel_pay_channel_id) {
		this.pay_channel_pay_channel_id = pay_channel_pay_channel_id;
	}
	
	public int getUser_user_id() {
		return user_user_id;
	}
	
	public void setUser_user_id(int user_user_id) {
		this.user_user_id = user_user_id;
	}
	
	public int getAddr_addr_id() {
		return addr_addr_id;
	}
	
	public void setAddr_addr_id(int addr_addr_id) {
		this.addr_addr_id = addr_addr_id;
	}
	
	
}
