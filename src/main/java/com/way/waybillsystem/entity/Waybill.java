package com.way.waybillsystem.entity;

import java.util.Date;

public class Waybill {
    private Long waybillNumber;

    private Long wsIdNewest;

    private Long userId;

    private String fromName;

    private String departure;

    private Date sendDate;

    private String fromCompanyName;

    private String fromAddress;

    private String fromPhone;

    private String isMsg;

    private String contents;

    private String toName;

    private String destination;

    private Date receiveDate;

    private String toCompanyName;

    private String toAddress;

    private String toPhone;

    private String pickedupBy;

    private Double weight;

    private Double dimensionl;

    private String isIns;

    private Long insuranceFee;

    private Long insuranceAmount;

    private Long timesOfCharge;

    private Long charge;

    private Long packageCharge;

    private Long totalCharge;

    private Integer paymentOption;

    private Integer paymentCharge;

    private String fromSignature;

    private String fromId;

    private String toId;

    private String waybillPic;

    private String toSignature;

    private Date createTime;

    public Long getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(Long waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public Long getWsIdNewest() {
        return wsIdNewest;
    }

    public void setWsIdNewest(Long wsIdNewest) {
        this.wsIdNewest = wsIdNewest;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName == null ? null : fromName.trim();
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure == null ? null : departure.trim();
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getFromCompanyName() {
        return fromCompanyName;
    }

    public void setFromCompanyName(String fromCompanyName) {
        this.fromCompanyName = fromCompanyName == null ? null : fromCompanyName.trim();
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress == null ? null : fromAddress.trim();
    }

    public String getFromPhone() {
        return fromPhone;
    }

    public void setFromPhone(String fromPhone) {
        this.fromPhone = fromPhone == null ? null : fromPhone.trim();
    }

    public String getIsMsg() {
        return isMsg;
    }

    public void setIsMsg(String isMsg) {
        this.isMsg = isMsg == null ? null : isMsg.trim();
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName == null ? null : toName.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getToCompanyName() {
        return toCompanyName;
    }

    public void setToCompanyName(String toCompanyName) {
        this.toCompanyName = toCompanyName == null ? null : toCompanyName.trim();
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress == null ? null : toAddress.trim();
    }

    public String getToPhone() {
        return toPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone == null ? null : toPhone.trim();
    }

    public String getPickedupBy() {
        return pickedupBy;
    }

    public void setPickedupBy(String pickedupBy) {
        this.pickedupBy = pickedupBy == null ? null : pickedupBy.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getDimensionl() {
        return dimensionl;
    }

    public void setDimensionl(Double dimensionl) {
        this.dimensionl = dimensionl;
    }

    public String getIsIns() {
        return isIns;
    }

    public void setIsIns(String isIns) {
        this.isIns = isIns == null ? null : isIns.trim();
    }

    public Long getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(Long insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public Long getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(Long insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public Long getTimesOfCharge() {
        return timesOfCharge;
    }

    public void setTimesOfCharge(Long timesOfCharge) {
        this.timesOfCharge = timesOfCharge;
    }

    public Long getCharge() {
        return charge;
    }

    public void setCharge(Long charge) {
        this.charge = charge;
    }

    public Long getPackageCharge() {
        return packageCharge;
    }

    public void setPackageCharge(Long packageCharge) {
        this.packageCharge = packageCharge;
    }

    public Long getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(Long totalCharge) {
        this.totalCharge = totalCharge;
    }

    public Integer getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(Integer paymentOption) {
        this.paymentOption = paymentOption;
    }

    public Integer getPaymentCharge() {
        return paymentCharge;
    }

    public void setPaymentCharge(Integer paymentCharge) {
        this.paymentCharge = paymentCharge;
    }

    public String getFromSignature() {
        return fromSignature;
    }

    public void setFromSignature(String fromSignature) {
        this.fromSignature = fromSignature == null ? null : fromSignature.trim();
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId == null ? null : fromId.trim();
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId == null ? null : toId.trim();
    }

    public String getWaybillPic() {
        return waybillPic;
    }

    public void setWaybillPic(String waybillPic) {
        this.waybillPic = waybillPic == null ? null : waybillPic.trim();
    }

    public String getToSignature() {
        return toSignature;
    }

    public void setToSignature(String toSignature) {
        this.toSignature = toSignature == null ? null : toSignature.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}