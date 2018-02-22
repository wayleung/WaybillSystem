package com.way.waybillsystem.entity;

import java.util.Date;

public class WaybillStatus {
    private Long wsId;

    private Long waybillNumber;

    private Integer status;

    private Integer locationNow;

    private Date lacationTime;

    private Long employeeCharge;

    private Date createTime;

    public Long getWsId() {
        return wsId;
    }

    public void setWsId(Long wsId) {
        this.wsId = wsId;
    }

    public Long getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(Long waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLocationNow() {
        return locationNow;
    }

    public void setLocationNow(Integer locationNow) {
        this.locationNow = locationNow;
    }

    public Date getLacationTime() {
        return lacationTime;
    }

    public void setLacationTime(Date lacationTime) {
        this.lacationTime = lacationTime;
    }

    public Long getEmployeeCharge() {
        return employeeCharge;
    }

    public void setEmployeeCharge(Long employeeCharge) {
        this.employeeCharge = employeeCharge;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}