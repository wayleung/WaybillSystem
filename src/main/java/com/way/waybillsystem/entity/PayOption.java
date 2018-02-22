package com.way.waybillsystem.entity;

public class PayOption {
    private Integer poId;

    private String poName;

    public Integer getPoId() {
        return poId;
    }

    public void setPoId(Integer poId) {
        this.poId = poId;
    }

    public String getPoName() {
        return poName;
    }

    public void setPoName(String poName) {
        this.poName = poName == null ? null : poName.trim();
    }
}