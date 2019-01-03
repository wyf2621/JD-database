package db.dao;

import java.util.List;

import db.entity.SpuTypeHasSpecGroup;

public interface SpuTypeHasSpecGroupDao extends BaseDao{

	public List<SpuTypeHasSpecGroup> findAll();
	
	public List<SpuTypeHasSpecGroup> findGroupID(int spec_group_spec_group_id);
	
	public SpuTypeHasSpecGroup findByID(int spu_type_spu_type_id);
}
