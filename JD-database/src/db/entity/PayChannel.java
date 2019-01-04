package db.entity;

public class PayChannel {

	private int pay_channel_id;
	private int pay_channel_type;
	private String pay_channel_type_no;
	private int user_user_id;
	public int getPay_channel_id() {
		return pay_channel_id;
	}
	public void setPay_channel_id(int pay_channel_id) {
		this.pay_channel_id = pay_channel_id;
	}
	public int getPay_channel_type() {
		return pay_channel_type;
	}
	public void setPay_channel_type(int pay_channel_type) {
		this.pay_channel_type = pay_channel_type;
	}
	public String getPay_channel_type_no() {
		return pay_channel_type_no;
	}
	public void setPay_channel_type_no(String pay_channel_type_no) {
		this.pay_channel_type_no = pay_channel_type_no;
	}
	public int getUser_user_id() {
		return user_user_id;
	}
	public void setUser_user_id(int user_user_id) {
		this.user_user_id = user_user_id;
	}
	
	
}
