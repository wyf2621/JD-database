package db.entity;

public class ShoppingCartHasSku {

	private int shopping_cart_shopping_cart_id;
	private int sku_sku_id;
	
	public int getShopping_cart_shopping_cart_id() {
		return shopping_cart_shopping_cart_id;
	}
	
	public void setShopping_cart_shopping_cart_id(int shopping_cart_shopping_cart_id) {
		this.shopping_cart_shopping_cart_id = shopping_cart_shopping_cart_id;
	}
	
	public int getSku_sku_id() {
		return sku_sku_id;
	}
	
	public void setSku_sku_id(int sku_sku_id) {
		this.sku_sku_id = sku_sku_id;
	}
}
