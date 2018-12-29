package db.entity;

public class Addr {

	private int addr_id;
	private String addr_country;
	private String addr_province;
	private String addr_city;
	private String addr_area;
	private String addr_detail;
	private boolean addr_is_default;
	private String addr_name;
	private String addr_tel;
	private int user_user_id;
	
	public int getAddr_id() {
		return addr_id;
	}
	
	public void setAddr_id(int addr_id) {
		this.addr_id = addr_id;
	}
	
	public String getAddr_country() {
		return addr_country;
	}
	
	public void setAddr_country(String addr_country) {
		this.addr_country = addr_country;
	}
	
	public String getAddr_province() {
		return addr_province;
	}
	
	public void setAddr_province(String addr_province) {
		this.addr_province = addr_province;
	}
	
	public String getAddr_city() {
		return addr_city;
	}
	
	public void setAddr_city(String addr_city) {
		this.addr_city = addr_city;
	}
	
	public String getAddr_area() {
		return addr_area;
	}
	
	public void setAddr_area(String addr_area) {
		this.addr_area = addr_area;
	}
	
	public String getAddr_detail() {
		return addr_detail;
	}
	
	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}
	
	public boolean isAddr_is_default() {
		return addr_is_default;
	}
	
	public void setAddr_is_default(boolean addr_is_default) {
		this.addr_is_default = addr_is_default;
	}
	
	public String getAddr_name() {
		return addr_name;
	}
	
	public void setAddr_name(String addr_name) {
		this.addr_name = addr_name;
	}
	
	public String getAddr_tel() {
		return addr_tel;
	}
	
	public void setAddr_tel(String addr_tel) {
		this.addr_tel = addr_tel;
	}
	
	public int getUser_user_id() {
		return user_user_id;
	}
	
	public void setUser_user_id(int user_user_id) {
		this.user_user_id = user_user_id;
	}
}
