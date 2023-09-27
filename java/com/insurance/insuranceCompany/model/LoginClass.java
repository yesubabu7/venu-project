package com.insurance.insuranceCompany.model;

public class LoginClass {
	int userId;
	String user_name;
	String password;
	int roleid;
	public LoginClass() {
		
	}

	public LoginClass(int userId, String user_name, String password, int roleid) {
		super();
		this.userId = userId;
		this.user_name = user_name;
		this.password = password;
		this.roleid = roleid;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginClass [user_name=" + user_name + ", password=" + password + "]";
	}
	public int getUserId() {
		return userId;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
}
