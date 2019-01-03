package db.dao;

import java.util.List;

import db.entity.SpecGroup;

public interface SpecGroupDao extends BaseDao{

	public SpecGroup findByID(int spec_group_id);
	
	public List<SpecGroup> findAll();
	
}
