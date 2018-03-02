package com.way.waybillsystem.entity;

import com.way.waybillsystem.enums.ResultEnum;

/**
 * Created by Administrator on 2017/9/23 0023.
 */
public class Result {
    //错误码
    private Integer code;

    //提示消息
    private String message;

    //存储对象
    private Object data;

    public Result() {
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = resultEnum.getData();
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
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
