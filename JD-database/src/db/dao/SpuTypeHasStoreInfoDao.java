package db.dao;

import java.util.List;

import db.entity.SpuTypeHasStoreInfo;

public interface SpuTypeHasStoreInfoDao extends BaseDao{

	public List<SpuTypeHasStoreInfo> findAll();
	
	public List<SpuTypeHasStoreInfo> findByStoreID(int spec_info_store_id);
	
	public SpuTypeHasStoreInfo findByID(int spu_type_spu_type_id);
}
