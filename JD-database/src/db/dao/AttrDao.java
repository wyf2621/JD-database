package db.dao;

import java.util.List;

import db.entity.Attr;

public interface AttrDao extends BaseDao{

	public List<Attr> findAll();
	
	public Attr findByID(int attr_id);
}
