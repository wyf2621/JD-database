package db.entity;

public class AttrValue {
	
	private int attr_value_id;
	private String attr_value_name;
	private int attr_attr_id;
	
	public int getAttr_value_id() {
		return attr_value_id;
	}
	
	public void setAttr_value_id(int attr_value_id) {
		this.attr_value_id = attr_value_id;
	}
	
	public String getAttr_value_name() {
		return attr_value_name;
	}
	
	public void setAttr_value_name(String attr_value_name) {
		this.attr_value_name = attr_value_name;
	}
	
	public int getAttr_attr_id() {
		return attr_attr_id;
	}
	
	public void setAttr_attr_id(int attr_attr_id) {
		this.attr_attr_id = attr_attr_id;
	}
	
}
