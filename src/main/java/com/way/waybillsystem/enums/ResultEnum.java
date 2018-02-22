package com.way.waybillsystem.enums;

/**
 * Created by Administrator on 2017/9/21 0021.
 */
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    INNER_ERROR(0,"内部错误"),
    SUCCESS(1, "成功"),
    ACCOUNTNOTNULL(100,"账号不能为空"),
    PASSWORDNOTNULL(101,"密码不能为空"),
    PASSWORDWRONG(102,"密码错误"),
    PASSWORDSUREWRONG(103,"两次密码不一样"),
    ACCOUNTNOTEXISTORPASSWORDWRONG(104,"账号不存在或者密码不正确"),
    ACCOUNTALREADYEXIST(105,"账号已经存在"),
    ACCOUNTNOTEXIST(106,"账号不存在"),
    ACCOUNTALREADYBINDWECHAT(107,"账号已经绑定微信"),
    USERIDNOTNULL(108,"用户id不能为空"),
    USERIDNOTEXIST(109,"用户不存在"),
    WAYBILLNUMBERNOTNULL(300, "运单号不能为空"),
    WAYBILLNOTEXIST(301,"运单不存在"),
	WAYBILLSTATUSNOTEXIST(302,"运单状态不存在"),
	WSIDNOTNULL(303,"运单ID不能为空"),
	STATUSNAMENOTNULL(400, "状态名不能为空"),
	STATUSNAMEALREADYEXIST(401, "状态名已经存在"),
	LACATIONNAMENOTNULL(500, "位置名不能为空"),
	LACATIONNAMEALREADYEXIST(502, "位置名已经存在"),
	LACATIONTIMENOTNULL(501, "到达时间不能为空"),
	EMPLOYEENAMENOTNULL(601, "员工名字不能为空"),
	PHONEALREADYEXIST(701, "手机号已经存在"),
	PHONENOTNULL(702, "手机号不能为空"),
	;
    //错误码
    private Integer code;

    //提示消息
    private String message;

    //存储对象
    private Object data;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    ResultEnum(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
