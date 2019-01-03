package db.dao;

import java.util.List;

import db.entity.SpuType;

public interface SpuTypeDao extends BaseDao{

	public SpuType findByID(int spu_type_id);
	
	public List<SpuType> findAll();
	
	public List<SpuType> findByFatherID(int spu_type_father_id);
	
}
