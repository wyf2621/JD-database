package db.dao;

import java.util.List;
import java.util.Set;

import db.entity.Spec;

public interface SpecDao extends BaseDao{

	public Spec findByID(int spec_id);
	
	public List<Spec> findAll();
	
	public List<Spec> findByGroupID(int group_id);
	
}
