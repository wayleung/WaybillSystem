package com.way.waybillsystem.entity;

public class Fee {
    private Integer feeId;

    private Integer locationSend;

    private Integer loacationReceive;

    private Long fee;

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

    public Integer getLoacationReceive() {
        return loacationReceive;
    }

    public void setLoacationReceive(Integer loacationReceive) {
        this.loacationReceive = loacationReceive;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }
}