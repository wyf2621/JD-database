package db.dao;

import java.util.List;

public class SpecGroupDao {

	private int spec_group_id;
	private List spec_group_name;
	
	public int getSpec_group_id() {
		return spec_group_id;
	}
	
	public void setSpec_group_id(int spec_group_id) {
		this.spec_group_id = spec_group_id;
	}
	
	public List getSpec_group_name() {
		return spec_group_name;
	}
	
	public void setSpec_group_name(List spec_group_name) {
		this.spec_group_name = spec_group_name;
	}
}
