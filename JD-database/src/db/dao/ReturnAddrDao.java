package db.dao;

import java.util.List;

import db.entity.ReturnAddr;

public interface ReturnAddrDao {

	public ReturnAddr findByID(int return_addr_id);
	
	public List<ReturnAddr> findAll();
	
	public List<ReturnAddr> findByStoreID(int store_id);
}
