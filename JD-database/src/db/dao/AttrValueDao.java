package db.dao;

import java.util.List;

import db.entity.AttrValue;

public interface AttrValueDao {

	public AttrValue findByID(int attr_value_id);
	
	public List<AttrValue> findAll();
	
	public List<AttrValue> findByAttrID(int attr_id);
} 
