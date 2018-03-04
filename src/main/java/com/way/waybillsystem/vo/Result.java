package com.way.waybillsystem.vo;

/**
 * 封装json对象，所有返回结果都使用它
 */

public class Result<T> {

	private boolean success;// 是否成功标志    true || false

	private T datas;// 成功时返回的数据

	private String msg;// 操作信息
	
	private String code;   //操作代码
	
	//有数据返回时true方法
	public Result trueResult(T datas,String msg,String code){
		return new Result(true,datas,msg,code);
	}
	
	//无数据返回时静态true方法
	public static Result trueResult(String msg,String code){
		return new Result(true,msg,code);
	}
	
	//无数据返回时静态false方法
	public static Result falseResult(String msg,String code){
		return new Result(false,msg,code);
	}
	
	public Result(boolean success, String msg, String code) {
		this.success = success;
		this.msg = msg;
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getDatas() {
		return datas;
	}

	public void setDatas(T datas) {
		this.datas = datas;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Result [success=" + success + ", datas=" + datas + ", msg=" + msg
				+ ", code=" + code + "]";
	}

	public Result(boolean success, T datas, String msg, String code) {
		this.success = success;
		this.datas = datas;
		this.msg = msg;
		this.code = code;
	}

	public Result() {
	}

}
