package db.entity;

public class PayChannel {

	private int pay_cahnnel_id;
	private int pay_cahnnel_type;
	private String pay_cahnnel_type_no;
	private int user_user_id;
	
	public int getPay_cahnnel_id() {
		return pay_cahnnel_id;
	}
	
	public void setPay_cahnnel_id(int pay_cahnnel_id) {
		this.pay_cahnnel_id = pay_cahnnel_id;
	}
	
	public int getPay_cahnnel_type() {
		return pay_cahnnel_type;
	}
	
	public void setPay_cahnnel_type(int pay_cahnnel_type) {
		this.pay_cahnnel_type = pay_cahnnel_type;
	}
	
	public String getPay_cahnnel_type_no() {
		return pay_cahnnel_type_no;
	}
	
	public void setPay_cahnnel_type_no(String pay_cahnnel_type_no) {
		this.pay_cahnnel_type_no = pay_cahnnel_type_no;
	}
	
	public int getUser_user_id() {
		return user_user_id;
	}
	
	public void setUser_user_id(int user_user_id) {
		this.user_user_id = user_user_id;
	}
}
