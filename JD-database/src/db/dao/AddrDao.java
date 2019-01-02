package db.dao;

import java.util.List;

import db.entity.Addr;

public interface AddrDao extends BaseDao{

	/**
	 * TODO find address by addr_id
	 * @param addr_id 
	 * @return address
	 */
	public Addr findByID(int addr_id);
	
	/**
	 * TODO find the list of all the address
	 * @return list of address
	 */
	public List<Addr> findAll();
	
	/**
	 * TODO find the list of address by user_id 
	 * @param user_id
	 * @return
	 */
	public List<Addr> findByUserID(int user_id);
	
}
