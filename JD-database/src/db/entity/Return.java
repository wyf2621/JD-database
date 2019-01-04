package db.entity;

public class Return {

	private int return_id;
	private int return_no;
	private String return_delivery_no;
	private int return_amount;
	private int return_status;
	private String return_apply_time;
	private String return_start_time;
	private String return_end_time;
	private String return_reason;
	private String return_note;
	private int order_order_id;
	private int user_user_id;
	
	public int getReturn_id() {
		return return_id;
	}
	
	public void setReturn_id(int return_id) {
		this.return_id = return_id;
	}
	
	public int getReturn_no() {
		return return_no;
	}
	
	public void setReturn_no(int return_no) {
		this.return_no = return_no;
	}
	
	public String getReturn_delivery_no() {
		return return_delivery_no;
	}
	
	public void setReturn_delivery_no(String return_delivery_no) {
		this.return_delivery_no = return_delivery_no;
	}
	
	public int getReturn_amount() {
		return return_amount;
	}
	
	public void setReturn_amount(int return_amount) {
		this.return_amount = return_amount;
	}
	
	public int getReturn_status() {
		return return_status;
	}
	
	public void setReturn_status(int return_status) {
		this.return_status = return_status;
	}
	
	public String getReturn_apply_time() {
		return return_apply_time;
	}
	
	public void setReturn_apply_time(String return_apply_time) {
		this.return_apply_time = return_apply_time;
	}
	
	public String getReturn_start_time() {
		return return_start_time;
	}
	
	public void setReturn_start_time(String return_start_time) {
		this.return_start_time = return_start_time;
	}
	
	public String getReturn_end_time() {
		return return_end_time;
	}
	
	public void setReturn_end_time(String return_end_time) {
		this.return_end_time = return_end_time;
	}
	
	public String getReturn_reason() {
		return return_reason;
	}
	
	public void setReturn_reason(String return_reason) {
		this.return_reason = return_reason;
	}
	
	public String getReturn_note() {
		return return_note;
	}
	
	public void setReturn_note(String return_note) {
		this.return_note = return_note;
	}
	
	public int getOrder_order_id() {
		return order_order_id;
	}
	
	public void setOrder_order_id(int order_order_id) {
		this.order_order_id = order_order_id;
	}
	
	public int getUser_user_id() {
		return user_user_id;
	}
	
	public void setUser_user_id(int user_user_id) {
		this.user_user_id = user_user_id;
	}
}

