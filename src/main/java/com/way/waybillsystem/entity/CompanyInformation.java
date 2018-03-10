package com.way.waybillsystem.entity;

public class CompanyInformation {
    private String name;

    private String location;

    private String website;

    private String email;

    private String phone;

    private String slogan;

    private String descriptionTitle;

    private String descriptionContent1;

    private String descriptionContent2;

    private String descriptionContent3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan == null ? null : slogan.trim();
    }

    public String getDescriptionTitle() {
        return descriptionTitle;
    }

    public void setDescriptionTitle(String descriptionTitle) {
        this.descriptionTitle = descriptionTitle == null ? null : descriptionTitle.trim();
    }

    public String getDescriptionContent1() {
        return descriptionContent1;
    }

    public void setDescriptionContent1(String descriptionContent1) {
        this.descriptionContent1 = descriptionContent1 == null ? null : descriptionContent1.trim();
    }

    public String getDescriptionContent2() {
        return descriptionContent2;
    }

    public void setDescriptionContent2(String descriptionContent2) {
        this.descriptionContent2 = descriptionContent2 == null ? null : descriptionContent2.trim();
    }

    public String getDescriptionContent3() {
        return descriptionContent3;
    }

    public void setDescriptionContent3(String descriptionContent3) {
        this.descriptionContent3 = descriptionContent3 == null ? null : descriptionContent3.trim();
    }
}