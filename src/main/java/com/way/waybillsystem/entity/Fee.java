package com.way.waybillsystem.entity;

public class Fee {
    private Integer feeId;

    private Integer locationSend;

    private Integer locationReceive;

    private Double fee;

    public Integer getFeeId() {
        return feeId;
    }

    public void setFeeId(Integer feeId) {
        this.feeId = feeId;
    }

    public Integer getLocationSend() {
        return locationSend;
    }

    public void setLocationSend(Integer locationSend) {
        this.locationSend = locationSend;
    }

    public Integer getLocationReceive() {
        return locationReceive;
    }

    public void setLocationReceive(Integer locationReceive) {
        this.locationReceive = locationReceive;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}