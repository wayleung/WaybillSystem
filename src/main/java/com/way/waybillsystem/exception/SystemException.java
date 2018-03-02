package com.way.waybillsystem.exception;
/**
 * 
* @author Way Liang 
* @Description: TODO(系统异常)   
* @date 2018年2月11日
 */
public class SystemException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private ErrorCodeConstant errorCode;

	public SystemException(ErrorCodeConstant errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public SystemException(ErrorCodeConstant errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public SystemException(ErrorCodeConstant errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public SystemException(ErrorCodeConstant errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public ErrorCodeConstant getErrorCode() {
		return errorCode;
	}

	public void setCode(ErrorCodeConstant errorCode) {
		this.errorCode = errorCode;
	}
}
