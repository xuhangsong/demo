package com.xhs.datasource.demo.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 *userName:用户名
 *mobilPhone:手机
 *type:员工标识，0临时员工；1普通员工；2管理员工;3用来确认访客权限的;4用来确认访客权限
 *pwdValue 密码
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 2724029689902203113L;
	private int id;
	private String openId;
	private String userName;
	private String mobilePhone;
	private String pwdValue;

	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getPwdValue() {
		return pwdValue;
	}
	public void setPwdValue(String pwdValue) {
		this.pwdValue = pwdValue;
	}
	
}
