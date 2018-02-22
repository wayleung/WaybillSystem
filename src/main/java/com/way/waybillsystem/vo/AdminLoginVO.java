package com.way.waybillsystem.vo;

public class AdminLoginVO {
	private String account;
	
	private String password;
	
	private String verifyCode;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	@Override
	public String toString() {
		return "AdminLoginVO [account=" + account + ", password=" + password + ", verifyCode=" + verifyCode + "]";
	}
	
	
}
