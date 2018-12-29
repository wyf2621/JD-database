package db.entity;

public class User {

	private int user_id;
	private String user_username;
	private String user_email;
	private String user_tel;
	private String user_password;
	private int user_status;
	
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_username() {
		return user_username;
	}
	
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	
	public String getUser_email() {
		return user_email;
	}
	
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	public String getUser_tel() {
		return user_tel;
	}
	
	
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	
	public String getUser_password() {
		return user_password;
	}
	
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	public int getUser_status() {
		return user_status;
	}
	
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
}
