package db.dao;

import java.util.List;

import db.entity.SpuHasSpec;

public interface SpuHasSpecDao extends BaseDao{

	public List<SpuHasSpec> findAll();
	
	public List<SpuHasSpec> findBySpecID(int spec_spec_id);
	
	public SpuHasSpec findByID(int spu_spu_id);
}
