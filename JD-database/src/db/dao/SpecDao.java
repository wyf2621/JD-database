package db.dao;

import java.util.List;
import java.util.Set;

public class SpecDao {

	private int spec_id;
	private List spec_name;
	private int spec_group_spec_group_id;
	
	public int getSpec_id() {
		return spec_id;
	}
	
	public void setSpec_id(int spec_id) {
		this.spec_id = spec_id;
	}
	
	public List getSpec_name() {
		return spec_name;
	}
	
	public void setSpec_name(List spec_name) {
		this.spec_name = spec_name;
	}
	
	public int getSpec_group_spec_group_id() {
		return spec_group_spec_group_id;
	}
	
	public void setSpec_group_spec_group_id(int spec_group_spec_group_id) {
		this.spec_group_spec_group_id = spec_group_spec_group_id;
	}
}
