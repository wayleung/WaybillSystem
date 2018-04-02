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
	E00000("E00000","登陆成功"),
	E00001("E00001","验证码错误(E00001)"),
	E00002("E00001","两次密码输入不一致(E00002)"),
	E00003("E00003","账号、密码、验证码不能为空(E00003)"),
	E00004("E00004","账号或密码错误(E00004)"),
	E00005("E00005","新增失败(E00005)"),
	E00006("E00006","更新失败(E00006)"),
	E00007("E00007","删除失败(E00007)"),
	E00008("E00008","查询失败(E00008)"),
	E00009("E00009","请先登陆并且使用微信端登录账户 才可绑定微信(E00009)"),
	E00010("E00010","请先登陆并且使用微信端登录账户 才可解绑微信(E00010)"),
	E00011("E00011","账号已经存在(E00011)"),
	E00012("E00012","请先微信端登录账户(E00012)"),
	E00013("E00013","请先登陆(E00013)"),
	E00014("E00014","用户还没绑定微信(E00014)"),
	E00015("E00015","不能存在该运单号(E00015)"),
	
	//Admin error
	
	//User error
	
	//Waybill error
	
	
	//WaybillStatus error
	
	
	//Wechat error
	E20001("E20001","获取access_token失败(E20001)"),

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
