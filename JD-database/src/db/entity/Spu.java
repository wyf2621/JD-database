package db.entity;

public class Spu {

	private int spu_id;
	private String spu_name;
	private int store_store_id;
	private int brand_brand_id;
	private int spu_type_spu_type_id;
	
	public int getSpu_id() {
		return spu_id;
	}
	
	public void setSpu_id(int spu_id) {
		this.spu_id = spu_id;
	}
	
	public String getSpu_name() {
		return spu_name;
	}
	
	
	public void setSpu_name(String spu_name) {
		this.spu_name = spu_name;
	}
	
	public int getStore_store_id() {
		return store_store_id;
	}
	
	public void setStore_store_id(int store_store_id) {
		this.store_store_id = store_store_id;
	}
	
	public int getBrand_brand_id() {
		return brand_brand_id;
	}
	
	public void setBrand_brand_id(int brand_brand_id) {
		this.brand_brand_id = brand_brand_id;
	}
	
	
	public int getSpu_type_spu_type_id() {
		return spu_type_spu_type_id;
	}
	
	public void setSpu_type_spu_type_id(int spu_type_spu_type_id) {
		this.spu_type_spu_type_id = spu_type_spu_type_id;
	}
	
}
