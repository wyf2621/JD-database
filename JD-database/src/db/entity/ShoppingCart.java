package db.entity;

public class ShoppingCart {

	private int shopping_cart_id;
	private int shopping_cart_sku_num;
	private String shopping_cart_create_time;
	private boolean shopping_cart_is_exist;
	private int user_user_id;
	
	public int getShopping_cart_id() {
		return shopping_cart_id;
	}
	
	public void setShopping_cart_id(int shopping_cart_id) {
		this.shopping_cart_id = shopping_cart_id;
	}
	
	public int getShopping_cart_sku_num() {
		return shopping_cart_sku_num;
	}
	
	public void setShopping_cart_sku_num(int shopping_cart_sku_num) {
		this.shopping_cart_sku_num = shopping_cart_sku_num;
	}
	
	public String getShopping_cart_create_time() {
		return shopping_cart_create_time;
	}
	
	public void setShopping_cart_create_time(String shopping_cart_create_time) {
		this.shopping_cart_create_time = shopping_cart_create_time;
	}
	
	public boolean isShopping_cart_is_exist() {
		return shopping_cart_is_exist;
	}
	
	public void setShopping_cart_is_exist(boolean shopping_cart_is_exist) {
		this.shopping_cart_is_exist = shopping_cart_is_exist;
	}
	
	public int getUser_user_id() {
		return user_user_id;
	}
	
	public void setUser_user_id(int user_user_id) {
		this.user_user_id = user_user_id;
	}
}
