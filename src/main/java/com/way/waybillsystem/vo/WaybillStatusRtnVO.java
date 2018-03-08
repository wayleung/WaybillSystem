package com.way.waybillsystem.vo;

import java.util.Date;

public class WaybillStatusRtnVO {
    private Long wsId;

    private Long waybillNumber;

    private String statusName;

    private String locationName;

    private Date lacationTime;

    private String name;

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

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Date getLacationTime() {
		return lacationTime;
	}

	public void setLacationTime(Date lacationTime) {
		this.lacationTime = lacationTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "WaybillStatusRtnVO [wsId=" + wsId + ", waybillNumber=" + waybillNumber + ", statusName=" + statusName
				+ ", locationName=" + locationName + ", lacationTime=" + lacationTime + ", name=" + name + "]";
	}


   
}