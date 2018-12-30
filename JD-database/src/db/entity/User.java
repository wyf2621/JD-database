package db.entity;

import java.util.Set;

public class User {

	private int user_id;
	private String user_username;
	private String user_email;
	private String user_tel;
	private String user_password;
	private int user_status;
	private Set<Addr> addrs;
	private Set<CouponHasUser> coupon_has_users;
	private Set<Order> orders;
	private Set<PayChannel> pay_channels;
	private Set<Return> returns;
	private Set<ShoppingCart> shopping_carts;
	private Set<Store> stores;
	private Set<UserInfo> user_infos;
	private Set<UserLoginOpen> user_login_opens;
	
	
	public Set<Addr> getAddrs() {
		return addrs;
	}

	public void setAddrs(Set<Addr> addrs) {
		this.addrs = addrs;
	}

	public Set<CouponHasUser> getCoupon_has_users() {
		return coupon_has_users;
	}

	public void setCoupon_has_users(Set<CouponHasUser> coupon_has_users) {
		this.coupon_has_users = coupon_has_users;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<PayChannel> getPay_channels() {
		return pay_channels;
	}

	public void setPay_channels(Set<PayChannel> pay_channels) {
		this.pay_channels = pay_channels;
	}

	public Set<Return> getReturns() {
		return returns;
	}

	public void setReturns(Set<Return> returns) {
		this.returns = returns;
	}

	public Set<ShoppingCart> getShopping_carts() {
		return shopping_carts;
	}

	public void setShopping_carts(Set<ShoppingCart> shopping_carts) {
		this.shopping_carts = shopping_carts;
	}

	public Set<Store> getStores() {
		return stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

	public Set<UserInfo> getUser_infos() {
		return user_infos;
	}

	public void setUser_infos(Set<UserInfo> user_infos) {
		this.user_infos = user_infos;
	}

	public Set<UserLoginOpen> getUser_login_opens() {
		return user_login_opens;
	}

	public void setUser_login_opens(Set<UserLoginOpen> user_login_opens) {
		this.user_login_opens = user_login_opens;
	}

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
