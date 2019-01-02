package db.entity;

public class Sku {

	private int sku_id;
	private String sku_name;
	private int spu_spu_id;

	public int getSku_id() {
		return sku_id;
	}
	
	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}
	
	public String getSku_name() {
		return sku_name;
	}
	
	public void setSku_name(String sku_name) {
		this.sku_name = sku_name;
	}
	
	public int getSpu_spu_id() {
		return spu_spu_id;
	}
	
	public void setSpu_spu_id(int spu_spu_id) {
		this.spu_spu_id = spu_spu_id;
	}
}
