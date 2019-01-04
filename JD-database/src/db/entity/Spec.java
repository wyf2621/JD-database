package db.entity;

import java.util.List;
import java.util.Set;

public class Spec {

	private int spec_id;
	private String spec_name;
	private int spec_group_spec_group_id;
	
	public String getSpec_name() {
		return spec_name;
	}

	public void setSpec_name(String spec_name) {
		this.spec_name = spec_name;
	}

	public int getSpec_id() {
		return spec_id;
	}
	
	public void setSpec_id(int spec_id) {
		this.spec_id = spec_id;
	}
	
	
	public int getSpec_group_spec_group_id() {
		return spec_group_spec_group_id;
	}
	
	public void setSpec_group_spec_group_id(int spec_group_spec_group_id) {
		this.spec_group_spec_group_id = spec_group_spec_group_id;
	}
}
