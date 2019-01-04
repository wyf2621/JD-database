package db.entity;

public class Sku {

	private int sku_id;
	private String sku_name;
	private int spu_spu_id;
	private float sku_price;
	private int sku_store;
	private int spec_spec_id;

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

	public float getSku_price() {
		return sku_price;
	}

	public void setSku_price(float sku_price) {
		this.sku_price = sku_price;
	}

	public int getSku_store() {
		return sku_store;
	}

	public void setSku_store(int sku_store) {
		this.sku_store = sku_store;
	}

	public int getSpec_spec_id() {
		return spec_spec_id;
	}

	public void setSpec_spec_id(int spec_spec_id) {
		this.spec_spec_id = spec_spec_id;
	}
}
