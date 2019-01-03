package db.dao;

import java.util.List;

import db.entity.PayChannel;

public interface PayChannelDao extends BaseDao{

	public List<PayChannel> findAll();
	
	public PayChannel findByID(int pay_channel_id);
	
	public List<PayChannel> findByUserID(int user_id);
}
