package db.entity;

public class SpuType {

	private int spu_type_id;
	private String spu_type_name;
	private int spu_type_father_id;
	
	public int getSpu_type_id() {
		return spu_type_id;
	}
	
	public void setSpu_type_id(int spu_type_id) {
		this.spu_type_id = spu_type_id;
	}
	
	public String getSpu_type_name() {
		return spu_type_name;
	}
	
	public void setSpu_type_name(String spu_type_name) {
		this.spu_type_name = spu_type_name;
	}
	
	public int getSpu_type_father_id() {
		return spu_type_father_id;
	}
	
	public void setSpu_type_father_id(int spu_type_father_id) {
		this.spu_type_father_id = spu_type_father_id;
	}
	
	
}
