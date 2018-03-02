package com.way.waybillsystem.exception;

import java.io.Serializable;

/**
 * 
* @author Way Liang 
* @Description: TODO(系统异常)   
* @date 2018年2月11日
 */

public enum ErrorCodeConstant implements Serializable {
	//common error
	E00001("E00001","验证码错误(E00001)"),
	E00002("E00001","两次密码输入不一致(E00002)"),
	E00003("E00003","账号、密码、验证码不能为空(E00003)"),
	E00004("E00004","账号或密码错误(E00004)"),
	E00005("E00005","新增失败(E00005)"),
	E00006("E00006","更新失败(E00006)"),
	E00007("E00007","删除失败(E00007)"),
	E00008("E00008","查询失败(E00008)"),
	//Admin error
	
	//User error
	
	//Waybill error
	
	
	//WaybillStatus error
	
	
	//Wechat error
	

	;
	
	

	private final String code;

	private final String message;

	private ErrorCodeConstant(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

}
