package db.entity;

public class SkuHasOrder {

	private int sku_sku_id;
	private int order_order_id;
	private int sku_has_order_sku_num;

	public int getSku_sku_id() {
		return sku_sku_id;
	}
	
	public void setSku_sku_id(int sku_sku_id) {
		this.sku_sku_id = sku_sku_id;
	}
	
	public int getOrder_order_id() {
		return order_order_id;
	}
	
	public void setOrder_order_id(int order_order_id) {
		this.order_order_id = order_order_id;
	}
	
	public int getSku_has_order_sku_num() {
		return sku_has_order_sku_num;
	}
	
	public void setSku_has_order_sku_num(int sku_has_order_sku_num) {
		this.sku_has_order_sku_num = sku_has_order_sku_num;
	}
}

