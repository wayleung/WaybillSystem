package com.way.waybillsystem.vo;

public class FeeRtnVO {
    private Integer feeId;

    private Integer locationSend;
    
    private String locationSendName;
    

    private Integer locationReceive;
    
    private String locationReceiveName;
    
	private Double fee;

    public String getLocationSendName() {
		return locationSendName;
	}

	public void setLocationSendName(String locationSendName) {
		this.locationSendName = locationSendName;
	}

	public String getLocationReceiveName() {
		return locationReceiveName;
	}

	public void setLocationReceiveName(String loacationReceiveName) {
		this.locationReceiveName = loacationReceiveName;
	}



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

    public void setLocationReceive(Integer loacationReceive) {
        this.locationReceive = loacationReceive;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}